// CS 2505 Spring 2022:  test driver for c01 Partition Integer
//
// Standard Library headers:
#include <stdio.h>             // for I/O functionality
#include <stdlib.h>            // for general features
#include <string.h>            // for C string library functionality
#include <inttypes.h>      // for exact-width integer types

// "Local" headers:
#include "PartitionInteger.h"  // for assigned function
#include "Generator.h"         // for test case generation
#include "checkAnswer.h"       // for grading functions

// Test driver for the PartitionInteger() function.
// Compile as:
//
//   gcc -o c01 -std=c11 -no-pie -Wall -W c01driver.c PartitionInteger.c Generator.o checkAnswer.o
// 
// Invoke as:
//             ./c01 <test case file> <results file> [-repeat]
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

// We will expect the longest line in the input file to contain no more than
// 100 characters (which is generous in this case).
const uint32_t MAX_LINE_LENGTH = 100;

// Unlike Java, in C we need to declare functions before they are called:
uint32_t checkCaseFile(FILE* caseFile);

// Of course, execution begins with main():
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
      printf("Invocation:  %s <test case file> <results file> [-repeat]\n", argv[0]);
      return 1;
   }
   
   // We will use the supplied names for the test case file and the results file:
   char* dataFileName = argv[1];
   char* resultsFileName = argv[2];
   
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
      Generate(dataFileName, nCases);
   }
   
   // Set some grading parameters:
   uint32_t ptsPerCase   = 10;
   uint32_t maximumScore = nCases * ptsPerCase;
   uint32_t totalScore   = 0;
   
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
   
   // Write a header for the test output to the results file:
   fprintf(results, "                         N    SEL      Returned\n");
   fprintf(results, "-----------------------------------------------\n");
   
   char Line[MAX_LINE_LENGTH + 1];        // holds the current input line
   char actionFlag[MAX_LINE_LENGTH + 1];  // holds the current Action
   uint32_t N = 0,                        // holds the integer to be "squeezed"
            partitionedN = 0;             // holds the "partitioned" integer
   
   // The loop uses the read-to-input-failure pattern.  That is, we will
   // attempt to read the next expected input from the file, and then
   // validate that reading, before we attempt to process any data.
   //
   // In the loop test, we take advantage of the fact that fgets() will
   // return NULL If it fails to read any input.  That will force the
   // loop to terminate when the end of the input file is reached.
   while ( fgets(Line, MAX_LINE_LENGTH, tests) != NULL ) {
      
      // Try to read the actionFlag from the input line that was just
      // read into Line; sscanf() will return 0 if nothing was read.
      // In that case, write a diagnostic message, skip the remainder of
      // the loop body and look for another line of input.
      if ( sscanf(Line, "%s", actionFlag) != 1 ) {
         printf("Failed to read an actionFlag value from %s\n", Line);
         continue;
      }
      
      // Try to read an integer value from the input line that was just
      // read into Line.  Here, we encounter one limitation of sscanf();
      // it does not maintain any knowledge of previous calls, so it
      // resumes reading from the beginning of Line.  We could sidestep
      // that issue by reading both the actionFlag and the integer in a
      // single call to sscanf(); but that makes checking the results of
      // the two read operations clumsy.
      //
      // Instead, we take advantage of a C format specifier feature; if
      // we follows the '%' with an asterisk, a value is read and then
      // discarded.
      //
      // In this case we reread the action flag value but don't save it.
      if ( sscanf(Line, "%*s %u", &N) != 1 ) {
         printf("Failed to read an integer value from %s\n", Line);
         continue;
      }
      
      // Determine whether the actionFlag indicates we should squeeze
      // out the even digits, or the odd digits, or that there was
      // something wrong with the actionFlag.
      //
      // strcmp() compares two (C-style) character strings; it returns
      // zero if the strings match, something negative if the first
      // string precedes the second string, and something positive if
      // the first string follows the second string.
      Ordering option;
      if ( strcmp(actionFlag, "even") == 0 ) {
         option = EVENHIGH;
      }
      else if ( strcmp(actionFlag, "odd") == 0 ) {
         option = ODDHIGH;
      }
      else {
         fprintf(results, "Unrecognized action flag: %s\n", actionFlag);
         continue;
      }
      // Compute the answer computed by the student's solution:
      partitionedN = PartitionInteger(N, option);
      
      // Now, check the computed answer:
      if ( checkAnswer(results, N, partitionedN, option) ) {
		  totalScore += ptsPerCase;
	  } 
   }

   // Write the total score to the results file:
   fprintf(results, "\n");
   fprintf(results, "Score:  %3"PRIu32" / %3"PRIu32"\n", totalScore, maximumScore);
   
   // It's important to explicitly close files when we are finished with
   // them, because:
   //   - the OS needs to know the files are no longer in use 
   //   - output written to a file is buffered and may not actually
   //     reach the file unless it is properly closed
   fclose(tests);
   fclose(results);
   
   // Traditionally, return 0 on successful termination.
   return 0;
}

/** Counts the number of test case lines in the specified test case file.
 * 
 *  Pre:  caseFile is open on a test case file that conforms to the spec
 *  Returns:  the number of lines in the file, which would equal the number of
 *            test cases supplied in that file
 */
uint32_t checkCaseFile(FILE* caseFile) {

   char Line[MAX_LINE_LENGTH + 1];
   
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
