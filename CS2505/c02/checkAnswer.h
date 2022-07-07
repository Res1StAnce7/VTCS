#ifndef CHECKANSWER_H
#define CHECKANSWER_H
#include <stdio.h>      // for FILE type
#include <inttypes.h>   // for exact-width integer types
#include <stdbool.h>    // for bool type

// DO NOT MODIFY THIS FILE IN ANY WAY!! //

/**  Compares a student result for a test case to a reference result.
 * 
 *   Pre:     The first 8 parameters specify the rectangles for the test case.
 *            solnOverlap specifies whether the student detected an overlap.
 *            The last 4 parameters specify the overlap the student computed,
 *              if the solnOverlap is true.
 *   Returns: true iff the student's result matches the reference result
 * 
 *   Called by:  main() in driver.c
 *   Calls:      only private helper functions
 */
bool checkAnswer(int32_t aSWx, int32_t aSWy, uint32_t aHeight, uint32_t aWidth,
                 int32_t bSWx, int32_t bSWy, uint32_t bHeight, uint32_t bWidth,
                 bool solnOverlap,
                 int32_t solnSWx, int32_t solnSWy, uint32_t solnHeight, uint32_t solnWidth,
                 FILE* log);

#endif
