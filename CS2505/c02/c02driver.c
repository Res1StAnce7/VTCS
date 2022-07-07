// CS 2505 Spring 2022
// Test driver for c02 (Possibly) Intersecting Rectangles
//
// Invocation:   ./c02driver <test case file> <results file> [-repeat]
//
// Standard headers:
#include <stdio.h>         // for I/O functions
#include <stdlib.h>        // generally useful
#include <inttypes.h>      // for exact-width integer types
#include <string.h>        // for C-string library
#include <stdbool.h>
#include <time.h>          // for system clock access

// "Local" headers:
#include "Intersection.h"  // for declaration of Intersection()
#include "Generator.h"     // input data generator
#include "checkAnswer.h"   // answer checking code

// Test driver for the Intersection() function.
// Compile as:
//
//   gcc -o c02 -std=c11 -no-pie -Wall -W c02driver.c Intersection.c Generator.o checkAnswer.o
// 
// Invoke as:
//             ./c02 <test case file> <results file> [-repeat]
//
// Then the program is invoked as shown above, main() receives the number of
// command-line arguments as the parameter argc, and receives the actual
// command-line arguments as an array of strings, called argv.
//
// If argc >= 3, then
//    argv[0]:   the name of the program, "c01driver"
//    argv[1]:   the name for the test case file
//    argv[2]:   the name for the results file
//
// The driver attempts to open the specified test case file.  If the file does
// not exist, the driver exits with an error message.  If the file exists, the
// driver counts the number of test cases in the file (in order to set grading
// parameters).
//
// If argc == 4, then
//    argv[3]:   the switch, "-repeat"
//
// The driver calls a test-case generator, which creates an input file
// containing a fixed number of randomly-generated test cases.  
//
// In both cases, your version of the function PartitionInteger() is applied to 
// each test case, and the results are passed to checkAnswer(), which uses a 
// reference version of the function to compute the correct solution, and compare 
// that to the results from your solution.
//
// The grading results are written to the specified results file.
//
// You may modify this file as you like, but this version of the file will be
// used in testing your submission.

#define MAX_LINE_LENGTH 100         // maximum number of chars in an input line
uint32_t checkCaseFile(FILE* caseFile);

int main(int argc, char* argv[]) {
	
   // This program expects the user to supply on the commmand line:
   //
   //    - the name for the file that will hold test cases
   //    - the name for the file that will hold the test results
   //    - (optionally) "-repeat", if the user wants to reuse test cases
   //      that have already been stored in a test case file
   //
   // Therefore, the program checks for the presence of the correct number 
   // of parameters, and exits with a diagnostic message if that is incorrect:
	if ( argc != 3 && argc != 4 ) {
      printf("Error:  wrong number of command line parameters.\n");
      printf("Invocation:  %s <test cases file> <results file> [-repeat]\n", argv[0]);
		exit(1);
	}

   // We will use the supplied names for the test case file and the results file:
   char* dataFileName     = argv[1];        // name of test data file
   char* resultsFileName  = argv[2];        // name of results file
   
   // The variable randomize keeps track of whether the user wants to generate
   // new test cases:
   bool  randomize = true;
   if ( argc == 4 && strcmp(argv[3], "-repeat") == 0 ) {
      randomize = false;
   }
   
   // Set default number of test cases desired; modify if you like...
   uint32_t nCases = 20;
   
   // If the user has specified -repeat, verify the test case file already
   // exists, and counnt the number of test cases it contains:
   if ( !randomize ) {
	   FILE* caseFile = fopen(dataFileName, "r");
	   if ( caseFile == NULL ) {
		  printf("Error:  could not find the test case file %s.\n", dataFileName);
		  return 2;
	   }
	   nCases = checkCaseFile(caseFile);
	   fclose(caseFile);
	   if ( nCases <= 0 ) {
	      printf("Error;  could not find any test cases in %s.\n", dataFileName);
	      return 3;
	   }
   }
   
   // If random data has been requested, generate the specified number 
   // of cases:
   if ( randomize ) {
      nCases = Generate(dataFileName);
   }
   
   // Set some variables used in computing your score:
   const uint32_t ptsPerCase = 10;   // number of points per test case
	uint32_t Score  = 0;              // total score from test cases
   
   // Attempt to open the specified input file; exit with a diagnostic
   // if it cannot be opened for reading:   
   FILE* tests = fopen(dataFileName, "r");
   if ( tests == NULL ) {
      printf("Could not open input file: %s\n", dataFileName);
      return 2; 
   }

   // Attempt to open the specified output file; exit with a diagnostic
   // if it cannot be opened for writing:   
   FILE* results = fopen(resultsFileName, "w");
   if ( results == NULL ) {
      printf("Could not open output file: %s\n", resultsFileName);
      fclose(tests);
      return 3;
   }
   
   // Variables used in keeping track if whether the your solution always 
   // gives the same answer:
   bool saidTrue  = false;
   bool saidFalse = false;
   
   // Create a place to store lines read from the test case file...
   char Line[MAX_LINE_LENGTH + 1];
   // ... and eat the two header lines (see the specification):
   fgets(Line, MAX_LINE_LENGTH + 1, tests);
   fgets(Line, MAX_LINE_LENGTH + 1, tests);

   // Variables to store the attributes of the two rectangles we are 
   // going to compare:
   int32_t aSWx, aSWy, aHeight, aWidth,   // specification of 1st rectangle
           bSWx, bSWy, bHeight, bWidth;   // specification of 2nd rectangle

   // Write a header for the table of test results we're going to write:
   fprintf(results, "     Rectangle A                         Rectangle B\n");
   fprintf(results, "     SW corner       Height    Width     SW corner       Height    Width\n");
   fprintf(results, "     -------------------------------------------------------------------\n");

   // Read the data for the first pair of rectangles.  The expected formatting is given
   // in the specification.  The return value is the number of values that were actually
   // assigned to our variables.  That had better be 8.
   int numRead = fscanf(tests, "%"PRId32"%"PRId32"%"PRId32"%"PRId32"%"PRId32"%"PRId32"%"PRId32"%"PRId32,
                              &aSWx, &aSWy, &aHeight, &aWidth, &bSWx, &bSWy, &bHeight, &bWidth);

   // As long as we just obtained the expected number of values, process the test case:
   while ( numRead == 8 ) {

      // Check for negative height or width values, which would be invalid:
      //if ( aHeight < 0 || aWidth < 0 || bHeight < 0 || bWidth ) {
		//	printf("Error:  test case includes negative height and/or width values.\n");
		//	return 4;
		//}
		
      // Write data for the current rectangles to results file, formatted nicely into
      // a table:
      fprintf(results, "     (%5"PRId32", %5"PRId32")   %5"PRId32"    %5"PRId32"     ", 
                              aSWx,       aSWy,         aHeight,      aWidth);
      fprintf(results, "(%5"PRId32", %5"PRId32")   %5"PRId32"    %5"PRId32"\n", 
                         bSWx,       bSWy,         bHeight,      bWidth);

      // Variables to store attributes of the intersection, if any:
      int32_t solnSWx, solnSWy;
      int32_t solnHeight, solnWidth;
      bool solnOverlap;
      
      // Check for intersection:
      if ( (solnOverlap = Intersection(aSWx, aSWy, aHeight, aWidth, bSWx, bSWy, bHeight, bWidth,
                                       &solnSWx, &solnSWy, &solnHeight, &solnWidth)) ) {
									
         fprintf(results, "     (%5"PRId32", %5"PRId32")   %5"PRId32"    %5"PRId32"\n", 
                                  solnSWx,   solnSWy,      solnHeight,   solnWidth);
         saidTrue = true;
	   }
	   else {
			fprintf(results, "     no intersection\n");
			saidFalse = true;
		}
		
		// Now, check the answer, and update the score:
		if ( checkAnswer(aSWx, aSWy, aHeight, aWidth, bSWx, bSWy, bHeight, bWidth,
                       solnOverlap, solnSWx, solnSWy, solnHeight, solnWidth, results) ) {
         fprintf(results, "Score:  %2"PRIu32" / %2"PRIu32"\n", ptsPerCase, ptsPerCase);
         Score += ptsPerCase;
		}
		else {
         fprintf(results, "Score:  %2"PRIu32" / %2"PRIu32"\n", 0, ptsPerCase);
		}
		fprintf(results, "\n");

      // Now, try to read data for the next case; when we get to the end of the test case
      // file, we will read fewer than 8 values here, and that will abort the loop.
      numRead = fscanf(tests, "%"PRId32"%"PRId32"%"PRId32"%"PRId32"%"PRId32"%"PRId32"%"PRId32"%"PRId32,
                       &aSWx, &aSWy, &aHeight, &aWidth, &bSWx, &bSWy, &bHeight, &bWidth);
                       
      // One point about the logic used in the loop.  By basing the loop exit on whether
      // we have read the expected number of data values for a test case, the loop will
      // (probably) exit if there's an error in the middle of the test case file.
      //
      // It is also possible to test to see if we've reached the end of the file; you can
      // look up the function feof() if you are curious about that.  I recommend NOT using
      // feof(), because it does not help us if the input file is incorrect in some way,
      // and it may not work in the manner you would expect.
   }

   fprintf(results, " -------------------------------------------------------------------\n");
   
   // Check for hardwired response:
   if ( !saidTrue || !saidFalse ) {
		fprintf(results, "Your implementation always returned the same answer!\n");
		fprintf(results, "Assigning a score of zero...");
		Score = 0;
	}
   
   // Report the score:
   fprintf(results, "\nTotal score:  %"PRIu32" / %"PRIu32"\n", Score, ptsPerCase*nCases);
   
   fclose(tests);    // close the input and output files
   fclose(results);
   
   // Exit the program:
   return 0;
}

uint32_t checkCaseFile(FILE* caseFile) {

   char Line[MAX_LINE_LENGTH + 1];
   
   // Eat the two expected header lines (we won't check contents):
   fgets(Line, MAX_LINE_LENGTH, caseFile);
   fgets(Line, MAX_LINE_LENGTH, caseFile);
   
   // The loop uses the read-to-input-failure pattern.  That is, we will
   // attempt to read the next expected input from the file, and then
   // validate that reading, before we attempt to process any data.
   //
   // In the loop test, we take advantage of the fact that fgets() will
   // return NULL If it fails to read any input.  That will force the
   // loop to terminate when the end of the input file is reached.
   uint32_t numberOfCases = 0;
   while ( fgets(Line, MAX_LINE_LENGTH, caseFile) != NULL ) {
	   numberOfCases++;
   }
   
   return numberOfCases;
}
