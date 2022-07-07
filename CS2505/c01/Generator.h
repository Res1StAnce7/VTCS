#ifndef GENERATOR_H
#define GENERATOR_H
#include <inttypes.h>
#include <stdbool.h>

// DO NOT MODIFY THIS FILE IN ANY WAY!! //

/**  Generate data for specified number of test cases and write them to the 
 *   specified file.
 * 
 *   Pre:  fName has been set to the desired name for the test case file
 *         nCases has been set to the desired number of test cases
 * 
 *   Returns:  the number of test cases generated
 */
void Generate(const char* const fName, uint32_t nCases);

#endif
