// Code for c03/q2 in Spring 2022 CS 2505
//
#include <stdio.h>        // for printf()
#include <stdlib.h>       // for atoi()
#include <assert.h>       // for assert()

// Declaration of helper function (defined after main()):
//
static int sumOfProducts(int x, int y);

int main(int argc, char** argv) {

   // validate the command-line invocation
   if ( argc != 3 ) {
      printf("Invocation:  q2  x  y\n");
      printf("   where x and y are integers and x <= y\n");
      exit(-1);
   }
   // validate the command-line argument values
   int a = atoi(argv[1]), 
       b = atoi(argv[2]);
   assert ( a <= b );
   
   // compute a value, strangely
   int result = sumOfProducts(a, b);
   // report the result
   printf("prod(%d, %d) == %d\n", a, b, result);
   
   return 0;
}

/** Computes a rather strange expression, recursively.
 * 
 *  Pre:     x <= y
 *  Returns: something strange
 */
static int sumOfProducts(int x, int y) {
	
	// base cases
	if ( x == y ) 
	   return x * y;
	if ( x + 1 == y ) 
	   return (x + 1) * y;
	
	// recursive computation
	int next = x * y + sumOfProducts(x + (y-x)/2, y);
	
	// return when recursion backs out...
	return next;
}
