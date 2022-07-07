#ifndef GENERATOR_H
#define GENERATOR_H
#include <stdio.h>
#include <inttypes.h>

// DO NOT MODIFY THIS FILE IN ANY WAY!! //

/**  Generate data for a preselected number of test cases and write them
 *   to the specified file.
 * 
 *   Pre:  fName has been set to the desired name for the test case file
 * 
 *   Returns:  the number of test cases generated
 */
uint32_t Generate(const char* const fName);

#endif /* GENERATOR_H */

