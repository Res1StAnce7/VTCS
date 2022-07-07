// Code for c03/q3 in Fall 2021 CS 2505
//
#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>

// Declaration of helper function (defined after main()):
//
int32_t q3(int32_t N);

int main(int argc, char** argv) {

   if ( argc != 2 ) {
      printf("Invocation:  q3 iterLimit, where iterLimit >= 0.\n");
      exit(1);
   }
   
   int32_t iterLimit = atoi(argv[1]);  // convert argument to an integer
   if ( iterLimit < 0 ) {
      printf("iterLimit must be non-negative.\n");
      exit(2);
   }

   int32_t retval = -1;
   int32_t pass = 1;	
   while ( pass < iterLimit ) {
      retval = q3(pass);
      pass++;
   }
   
   return 0;
}

/** Computes a rather strange expression.
 * 
 *  Pre:     N is initialized
 *  Returns: something strange
 */
int32_t q3(int32_t N) {
	
   static int32_t dejavue = 1;    // dejavue retains its value for next call

   dejavue = N * dejavue + dejavue % 103;  // perform strange computation
   
   return ( dejavue % 1201 );  // return value between 0 and 500, inclusive
}
