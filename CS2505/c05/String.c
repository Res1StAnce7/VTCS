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
#include "String.h"
#include <stdlib.h>
#include <assert.h>

/** The String is initialized to hold the values in *src.
 *
 *  Pre:
 *    *pSrc is C string with length up to slength (excludes null char)
 *  Post on success:
 *    A new, proper String object S is created such that:
 *       S.pData != pSrc->pData
 *       Up to slength characters in *pSrc are copied into dest->data
 *         (after dynamic allocation) and the new string is terminated
 *         with a '\0'
 *       S.length is set to the number of characters copied from *pSrc;
 *         this is no more than slength, but will be less if a '\0' is
 *         encountered in *pSrc before slength chars have occurred
 * Post on failure:
 *    NULL is returned
 * 
 * Returns:
 *    pointer to the new String object;
 *    NULL value if some error occurs
 */
String* String_Create(const char* const pSrc, uint32_t slength) {
   String* str = malloc(sizeof(String));
   str->pData = malloc((slength + 1));
   str->length = slength;

   for(uint32_t i = 0; i < slength; i++){
      str->pData[i] = pSrc[i];
   }
   str->pData[slength] = '\0';

   return str;
}

/** Makes an exact, full copy of a String.
 * 
 * Pre:
 *   *pSrc is a proper String object
 * Post:
 *    no memory leaks have occurred
 *   A new, proper string object S has been created such that S is a
 *      copy of *pSrc
 *
 * Returns:
 *   pointer to a String object which holds a copy of *pSrc;
 *    NULL if failure occurs
 */
String* String_strcpy(const String* const pSrc) {
   String* str = malloc(sizeof(String));
   str->pData = malloc(pSrc->length + 1);
   str->length = pSrc->length;

   for (uint32_t i = 0; i < pSrc->length; i++){
      str->pData[i] = pSrc->pData[i];
   }
   str->pData[pSrc->length] = '\0';

   return str;
}

/** Appends the String *pSrc to the String *pDest.
 * 
 *  Pre:
 *    *pDest is a proper String object
 *    *pSrc is is a proper String object
 *    pSrc != pDest (i.e., the source and destination are different String objects)
 *  Post on success:
 *    pSrc->pData is appended to the String pDest->pData
 *    *pDest is a proper String object  
 *  Post on failure:
 *    *pDest is unchanged
 * 
 *  Returns:
 *    the length of pDest->pData, if nothing goes wrong;
 *    a negative value, if some error occurs
 */
int32_t String_strcat(String *const pDest, const String *const pSrc){
   uint32_t length = pDest->length + pSrc->length;
   pDest->pData = realloc(pDest->pData, length + 1);

   uint32_t i = pDest->length;
   for (uint32_t j = 0; pSrc->pData[j] != '\0'; j++){
      pDest->pData[i] = pSrc->pData[j];
      i++; 
   }
   pDest->pData[length] = '\0';
   pDest->length = length;

   return (int32_t)length;
}

/** Compares two Strings.
 * 
 *  Pre:
 *    *pLeft is a proper String object
 *    *pRight is is a proper String object
 *
 *  Returns:
 *    < 0 if *pLeft precedes *pRight, lexically
 *      0 if *pLeft equals *pRight
 *    > 0 if *pLeft follows *pRight, lexically
 */
int32_t String_strcmp(const String* const pLeft, const String* const pRight) {
   uint32_t llength = pLeft->length;
   uint32_t rlength = pRight->length;
   uint32_t length = (llength > rlength) ? rlength : llength;
   
   for (uint32_t i = 0; i < length; i++){
      if (pLeft->pData[i] < pRight->pData[i]){
         return -1;
      }
      else if(pLeft->pData[i] > pRight->pData[i]){
         return 1;
      }
   }

   if (llength > rlength){
      return 1;
   }
   else if (llength < rlength){
      return -1;
   }
   return 0;
}

/** Looks for first occurence of a needle in a haystack.
 * 
 *  Pre: *pHaystack and *pNeedle are proper String objects
 *  
 *  Returns: index of the beginning of the first occurrence of the needle
 *           in the given haystack; -1 if there is no occurrence
 */
int32_t String_strstr(const String* const pHaystack, const String* const pNeedle) {
   for (uint32_t i = 0; i < pHaystack->length - pNeedle->length; i++){
      uint32_t j;
      for(j = 0; j < pNeedle->length; j++){
         if (pHaystack->pData[i + j] != pNeedle->pData[j]){
            break;
         }
      }
      if (j == pNeedle->length){
         return i;
      }
   }
   return -1;
}
 
/** Reports length of the character sequence.
 * 
 *  Pre:
 *    *pStr is a proper String object
 * 
 *  Returns:
 *    Number of characters in *pStr
 */
uint32_t String_strlen(const String* const pStr) {
   assert(pStr != NULL);
   return (pStr->length);
}

/** Makes an exact, full copy of a substring.
 * 
 * Pre:
 *   *pSrc is a proper String object
 *   startIdx + length <= pSrc->length
 * Post:
 *    no memory leaks have occurred
 *   A new, proper string object S has been created such that S holds
 *      the specified substring of *pSrc
 *
 * Returns:
 *   pointer to a String object which holds a copy of specified substring;
 *    NULL if failure occurs
 */
String* String_subString(const String* const pSrc, uint32_t start, uint32_t length) {
   String* str = malloc(sizeof(String));
   str->pData = malloc((length + 1));
   str->length = length;

   for(uint32_t i = 0; i < length; i++){
      str->pData[i] = pSrc->pData[start + i];
   }
   str->pData[length] = '\0';

   return str;
}


/**  Deallocates a String object and all its content.
 * 
 *   Pre:
 *     *ppStr is a pointer to a proper String object, so
 *     **ppStr is a proper String object
 *     **ppStr was allocated dynamically
 *   Post:
 *     (**ppStr).data has been deallocated
 *     **ppStr has been deallocated
 *     *ppStr == NULL
 */
void String_Dispose(String** ppStr){
   free((*ppStr)->pData);
   free(*ppStr);
   *ppStr = NULL;
}


