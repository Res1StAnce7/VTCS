#ifndef CHECKANSWER_H
#define CHECKANSWER_H
#include <stdio.h>
#include <inttypes.h>
#include <stdbool.h>
#include "PartitionInteger.h"

// DO NOT MODIFY THIS FILE IN ANY WAY!! //

/** Compares a student answer to the reference answer.
 * 
 *   Pre:  fp is open on an output file
 *         origValue stores the original value of the integer being used for the test
 *         stuAnswer stores the result computed by the student's solution
 *         option is set the same value passed to the student's solution
 *   Returns:  true iff the stuAnswer matches the reference result
 */
bool checkAnswer(FILE* fp, uint32_t origValue, uint32_t stuAnswer, Ordering option);

#endif
