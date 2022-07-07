/**  Driver for c04, CS 2505 Spring 2022
 * 
 *   Invocation:  c04 <option> [-repeat]
 * 
 *   Compile as:  
 *       gcc -o c04 -std=c11 -no-pie -Wall -W c04driver.c PtrFuncs.c Generator.o TestCode.o
 * 
 *   where option is one of the following selectors:
 *      -showBytes
 *      -showValues
 *      -findByte
 *      -findSequence
 *      -copyBlock
 *      -blendBytes
 * 
 *   If the -repeat switch is used, the same test data that was used on the
 *   previous test run will be used; this depends on the existence of a text
 *   file, Seed.txt, that contains the random seed that was saved in the 
 *   most recent run (without the -repeat switch).
 *   
 *   Depending on the selector, exactly one of the specified functions will be
 *   tested. Each test will generate three text output files:
 * 
 *      - a reference file containing the test cases and correct results
 *      - a file containing the results from your solution on the same data
 *      - a hexdump file, DataBlock.txt, showing the test region that was used
 * 
 *   You can use the supplied compare tool to compare the reference results to
 *   your results and generate a score.
 */
 
#include <stdio.h>
#include <stdint.h>
#include <inttypes.h>
#include <time.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#include "PtrFuncs.h"
#include "Generator.h"
#include "TestCode.h"

enum _Selector {SHOWBYTES, SHOWVALUES, FINDBYTE, FINDSEQUENCE, COPYBLOCK, BLENDBYTES, BADSELECTOR};
typedef enum _Selector Selector;

static void displayInvocation();
static void setSeedValue(int argc, char** argv);
static Selector parseSelection(char* option);


#define BLOCK_LENGTH 1024   // generate 1 KB random data block

int main(int argc, char** argv) {
   
   // Set up the random generator
   setSeedValue(argc, argv);
   
   // Generate the data block for testing
   uint8_t* dataBlock = genDataBlock( BLOCK_LENGTH );
   
   // Write memory block hex dump to file so students can see it
   FILE* hexDmp = fopen("DataBlock.txt", "w");
   writeDataBlock(hexDmp, dataBlock, BLOCK_LENGTH);
   fclose(hexDmp);
   
   // Determine the option chosen by the user:
   Selector selection = parseSelection(argv[1]);

   switch ( selection ) {
   case SHOWBYTES:    testShowBytesAtOffset(dataBlock, BLOCK_LENGTH);
                      break;
   case SHOWVALUES:   testShowValueAtOffset(dataBlock, BLOCK_LENGTH);
                      break;
   case FINDBYTE:     testFindOccurrencesOfByte(dataBlock, BLOCK_LENGTH);
                      break;
   case FINDSEQUENCE: testFindOccurrencesOfSequence(dataBlock, BLOCK_LENGTH);
                      break;
   case COPYBLOCK:    testCopyBlock(dataBlock, BLOCK_LENGTH);
                      break;
   case BLENDBYTES:   testBlendBytes(dataBlock, BLOCK_LENGTH);
                      break;
   default:           printf("Invalid selector: %s\n", argv[1]);
   }
   
   return 0;
}

static Selector parseSelection(char* option) {
	
	if ( strcmp(option, "-showBytes") == 0 ) {
		return SHOWBYTES;
	}
	if ( strcmp(option, "-showValues") == 0 ) {
		return SHOWVALUES;
	}
	if ( strcmp(option, "-findByte") == 0 ) {
		return FINDBYTE;
	}
	if ( strcmp(option, "-findSequence") == 0 ) {
		return FINDSEQUENCE;
	}
	if ( strcmp(option, "-copyBlock") == 0 ) {
		return COPYBLOCK;
	}
	if ( strcmp(option, "-blendBytes") == 0 ) {
		return BLENDBYTES;
	}
	return BADSELECTOR;
}


static void displayInvocation() {
	
   printf("Invocation:  c04 <option> [-repeat]\n");
   printf("  option must be one of the following:\n");
   printf("      -showBytes\n");
   printf("      -showValues\n");
   printf("      -findByte\n");
   printf("      -findSequence\n");
   printf("      -copyBlock\n");
   printf("      -blendBytes\n");
}

static void setSeedValue(int argc, char** argv) {

   unsigned int seedValue;
   
   if ( argc < 2 ) {
	  displayInvocation();
	  exit(-1);
   }
   else if ( argc == 2 ) {
      seedValue = time(NULL);
      FILE* fp = fopen("Seed.txt", "w");
      fprintf(fp, "%d\n", seedValue);
      fclose(fp);
   }
   else if ( argc == 3 && strcmp(argv[2], "-repeat") == 0 ){
      FILE* fp = fopen("Seed.txt", "r");
      if ( fp == NULL ) {
		  printf("No seed file was found.\n");
		  printf("You must first run this with the -rand switch!\n");
		  exit(-1);
	  }
      fscanf(fp, "%u", &seedValue);
      fclose(fp);
   }

   // seed the random generator
   srand( seedValue );
}
