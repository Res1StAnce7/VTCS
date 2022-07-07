//  On my honor: 
//  
//  - I have not discussed the C language code in my program with 
//    anyone other than my instructor or the teaching assistants  
//    assigned to this course. 
//  
//  - I have not used C language code obtained from another student,  
//    the Internet, or any other unauthorized source, either modified 
//    or unmodified.   
//  
//  - If any C language code or documentation used in my program  
//    was obtained from an authorized source, such as a text book or 
//    course notes, that has been clearly noted with a proper citation 
//    in the comments of my program. 
//  
//  - I have not designed this program in such a way as to defeat or 
//    interfere with the normal operation of the Curator System. 
// 
//    Siliang Zhang
//    s589z417
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include "Untangle.h"

// Reverses the bits in a byte
uint8_t reverseBits(uint8_t n);

/**
 *  Untangle() parses a chain of records stored in the memory region pointed
 *  to by pBuffer, and stores WordRecord objects representing the given data
 *  into the array supplied by the caller.
 * 
 *  Pre:    Fmt == CLEAR or ENCRYPTED
 *          pBuffer points to a region of memory formatted as specified
 *          wordList points to an empty array large enough to hold all the
 *             WordRecord objects you'll need to create
 *  Post:   wordList[0:nWords-1] hold WordRecord objects, where nWords is
 *             is the value returned by Untangle()
 *  Returns: the number of "words" found in the supplied quotation.
 */
uint8_t Untangle(DataFormat Fmt, const uint8_t* pBuffer, WordRecord* const wordList){
    uint16_t next = *(uint16_t*)pBuffer;
    uint16_t offset;
    char* word;
    uint8_t length;
    uint8_t i = 0;
    
    if (Fmt == CLEAR){
        do{
            offset = next;
            length = *(pBuffer + offset);
            word = calloc(length - 2, 1);

            if (offset != 0){
                memcpy(word, pBuffer + offset + 3, length - 3);
                word[length - 3] = '\0';
                wordList[i].offset = offset + 3;
                wordList[i].word = word;
                next = *(uint16_t*)(pBuffer + offset + 1);

                i++;
            }
        }while(offset != 0); 
    }
    else{
        uint8_t j;
        uint8_t maskForNext;
        uint8_t* bytes = malloc(sizeof(uint8_t) * 2);

        do{
            offset = next;
            printf("offset: %04x i: %d\n", offset, i);
            printf("%04x\n", next);
            length = *(pBuffer + offset);
            word = calloc(length - 2, 1);  
            
            if (offset != 0){
                for (j = 0; j < length - 3; j++){
                    uint8_t num = *(uint8_t*)(pBuffer + offset + j + 3);
                    uint8_t reverse = reverseBits(length - 3);
                    char* s = calloc(3, 1);
                    if (j == 0){
                        maskForNext = num ^ reverse;
                    }
                    sprintf(s, "%c", num ^ reverse);
                    strcat(word, s);
                    free(s);
                }
                word[length - 3] = '\0';
                wordList[i].offset = offset + 3;
                wordList[i].word = word;

                bytes[0] = *(pBuffer + offset + 1) ^ maskForNext;
                bytes[1] = *(pBuffer + offset + 2) ^ maskForNext;
                next = *(uint16_t*)bytes;

                i++;
            }
        }while(offset != 0);
        free(bytes);
    }
    free(word);

    return i;
}

/**
 *  Deallocates an array of WordRecord objects.
 * 
 *  Pre:    wordList points to a dynamically-allocated array holding nWords
 *             WordRecord objects
 *  Post:   all dynamic memory related to the array has been freed
 */
void clearWordRecords(WordRecord* const wordList, uint8_t nWords){
    for(uint8_t i = 0; i < nWords; i++){
        free(wordList[i].word);
    }
    free(wordList);
}

uint8_t reverseBits(uint8_t n){
    uint8_t ans = 0;
    for(int i = 7; i >= 0; i--){
        ans |= ((n & 1) << i);
        n >>= 1;
    }
    return ans;
}