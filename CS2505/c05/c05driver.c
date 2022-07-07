//  Test driver for String assignment.
//
// Compile: gcc -o c05 -std=c11 -no-pie -Wall -Wextra -ggdb3 c05driver.c String.c testString.o
// Memorycheck: ./gradeC05.sh String.c c05Grading.tar
// Invocation:  ./c05 <-mode> [-repeat]
//    where -mode, if present, is one of the following:
//        -all
//        -create
//        -compare
//        -cat
//        -copy
//        -strstr
//        -substring
//
// If the -repeat switch is omitted, the driver will create a random set
// of test cases, and save the random seed in a file; if the -repeat
// switch is present, the driver will open the previously-created seed
// file and use that to reproduce the previous set of test cases.
//
//  Summary results are written to Log.txt; individual test logs are also
//  written for each function tested.
//
//  The evaluation of String_Dispose() is based on Valgrind output.
//
// Library headers for various features:
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <inttypes.h>
#include <stdbool.h>
#include <string.h>

enum _testMode {ALL, CREATE, COMPARE, CAT, COPY, STRSTR, SUBSTRING, NOMODE};
typedef enum _testMode testMode;

// "Local" headers for testing code and solution:
#include "String.h"
#include "testString.h"

// Declarations of local helper functions:
static testMode setMode(char* specifier);

int main(int argc, char** argv) {
   
    bool ckCreate    = false,   // Controls for which test(s) are to be performed;
         ckCompare   = false,   //   set based on first command-line parameter
         ckCat       = false,
         ckCopy      = false,
         ckStrstr    = false,
         ckSubstring = false;
   
    // Validate number of parameters:
    if ( argc != 2 && argc != 3 ) {
       printf("Invocation:  driver <-mode> [-repeat]\n");
       printf("   where -mode  is -all, -create, -compare, -cat, -copy, -strstr, or -substring\n");
       exit(-1);
    }
    
    // Variable for random seed:
    unsigned int Seed = 0;
   
    // Determine which tests are to be performed:
    testMode mode = setMode(argv[1]);

    switch ( mode ) {
    case ALL:
           ckCreate = ckCompare = ckCat = ckCopy = ckStrstr = ckSubstring = true;
           break;
    case CREATE:
           ckCreate = true;
           break;
    case COMPARE:
           ckCompare = true;
           break;
    case CAT:
           ckCat = true;
           break;
    case COPY:
           ckCopy = true;
           break;
    case STRSTR:
           ckStrstr = true;
           break;
    case SUBSTRING:
           ckSubstring = true;
           break;
    default:
           printf("Illegal mode selected: %s\n", argv[1]);
           exit(-2);
	};
	
    // Determine if data should be randomized:
    if ( argc == 3 && strcmp(argv[2], "-repeat") == 0 ) {
       FILE* fp = fopen("seed.txt", "r");
       if ( fp == NULL ) {
            printf("Could not open seed file... run without -repeat.\n");
            exit(2);
        }
       fscanf(fp, "%u", &Seed);
       fclose(fp);
    }
    else if ( argc == 3 ) {
       printf("Unrecognized option: %s\n", argv[1]);
       exit(3);
    }
    else {
       Seed = time(NULL);
       FILE* fp = fopen("seed.txt", "w");
       fprintf(fp, "%u\n", Seed);
       fclose(fp);
    }
    srand( Seed );
   
    // Open overall log file:
    char* logFileName = "Log.txt";
    FILE* Out = fopen(logFileName, "w");

    // Grade values:
    uint32_t ptsEarned = 0;     // total points earned on selected test(s)
    uint32_t ptsPossible = 0;   // total points possible on selected test(s)
    uint32_t ptsThisTest;       // points earned on current test
    uint32_t maxThisTest;       // points possible on current test
   
    // Perform the selected test(s):
    if ( ckCreate ) {
       bool passed = testStringCreate(&ptsThisTest, &maxThisTest);
       fprintf(Out, "  1 >> String_Create() score: %"PRIu32" / %"PRIu32"\n", ptsThisTest, maxThisTest);
       ptsEarned += ptsThisTest;
       ptsPossible += maxThisTest;
   
       if ( !passed ) {
          fprintf(Out, "Failed test of String_Create().  Aborting testing.\n");
          return 0;
       }
	}
   
    if ( ckCompare ) {
       testStringCompare(&ptsThisTest, &maxThisTest);
       fprintf(Out, "  2 >> String_Compare() score: %"PRIu32" / %"PRIu32"\n", ptsThisTest, maxThisTest);
       ptsEarned += ptsThisTest;
       ptsPossible += maxThisTest;
	}
	
	if ( ckCat ) {
       testStringCat(&ptsThisTest, &maxThisTest);
       fprintf(Out, "  3 >> String_Cat() score: %"PRIu32" / %"PRIu32"\n", ptsThisTest, maxThisTest);
       ptsEarned += ptsThisTest;
       ptsPossible += maxThisTest;
	}
	
	if ( ckCopy ) {
       testStringCopy(&ptsThisTest, &maxThisTest);
       fprintf(Out, "  4 >> String_Copy() score: %"PRIu32" / %"PRIu32"\n", ptsThisTest, maxThisTest);
       ptsEarned += ptsThisTest;
       ptsPossible += maxThisTest;
	}
	
	if ( ckStrstr ) {
       testStringStrstr(&ptsThisTest, &maxThisTest);
       fprintf(Out, "  5 >> String_Strstr() score: %"PRIu32" / %"PRIu32"\n", ptsThisTest, maxThisTest);
       ptsEarned += ptsThisTest;
       ptsPossible += maxThisTest;
	}
	
	if ( ckSubstring ) {
       testStringSubstring(&ptsThisTest, &maxThisTest);
       fprintf(Out, "  6 >> String_Substring() score: %"PRIu32" / %"PRIu32"\n", ptsThisTest, maxThisTest);
       ptsEarned += ptsThisTest;
       ptsPossible += maxThisTest;
	}
	
	// Close the overall log file.
    fclose(Out);
    return 0;
}

/**  Determines which test mode has been selected by the user.
 * 
 *   Pre:  specifier is the first command-line parameter set by the user
 * 
 *   Returns:  the appropriate testMode value
 */
static testMode setMode(char* specifier) {
	
	if ( strcmp(specifier, "-all") == 0 ) {
	   return ALL;
	}
	if ( strcmp(specifier, "-create") == 0 ) {
	   return CREATE;
	}
	if ( strcmp(specifier, "-compare") == 0 ) {
	   return COMPARE;
	}
	if ( strcmp(specifier, "-cat") == 0 ) {
	   return CAT;
	}
	if ( strcmp(specifier, "-copy") == 0 ) {
	   return COPY;
	}
	if ( strcmp(specifier, "-strstr") == 0 ) {
	   return STRSTR;
	}
	if ( strcmp(specifier, "-substring") == 0 ) {
	   return SUBSTRING;
	}
	return NOMODE;	
}
