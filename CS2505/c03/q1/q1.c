// Code for c03/q1 in Spring 2022 CS 2505
//
#include <stdio.h>        // for printf()
#include <inttypes.h>     // for exact-width integer types
#include <stdlib.h>       // for exit(), atoi(), strtol(), abs()

int main(int argc, char** argv) {

   // validate the command-line invocation
   if ( argc != 3 ) {
      printf("Invocation:  q1  x  y\n");
      printf("   where x and y are integers\n");
      exit(-1);
   }
   
   // try to convert the parameters from strings to integer values
   int32_t X = atoi(argv[1]);
   int32_t Y = atoi(argv[2]);
   
   // show what the user entered
   printf("You entered %"PRId32" and %"PRId32"\n", X, Y);
   
   uint32_t LT0 = 0;
   if ( X < Y ) {
      LT0 = 1;
   }
   
   // Now compare with a typecast on X:
   uint32_t LT1 = 0;
   if ( (uint32_t) X < Y ) {
      LT1 = 1;
   }

   // Now compare with a seemingly redundant cast (since Y > 0):
   uint32_t LT2 = 0;
   if ( X < (uint32_t) Y ) {
      LT2 = 1;
   }
  
   // And, now a variation of the previous one:
   uint32_t GT1 = 1;
   if ( (uint32_t) Y > X ) {
      GT1 = 0;
   }

   return 0;
}
