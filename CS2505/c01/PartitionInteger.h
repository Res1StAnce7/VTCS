#ifndef PARTITIONINTEGER_H
#define PARTITIONINTEGER_H
#include <inttypes.h>

// DO NOT MODIFY THIS FILE IN ANY WAY!! //

// Rather than use a nondescriptive label, or none at all, we will use
// an enumerated type to make the logic of of the code clearer:
enum _Ordering {EVENHIGH, ODDHIGH};
typedef enum _Ordering Ordering;

/**  Computes a new integer from N by separating all the even digits
 *   digits from N and all the odd digits from N. 
 * 
 * For example:
 *  {23410, EVENFIRST}   --> 24031
 *  {23410, ODDFIRST}    --> 31240
 *  {2640, ODDFIRST}     --> 2640
 *  {1023712, EVENFIRST} --> 221371
 * 
 * Pre:  N is initialized
 *       Ordering is EVENHIGH or ODDHIGH
 * Returns:  integer obtained by reordering the digits of N as described
 *
 * Restrictions:
 *   - uses only its parameters and local automatic variables
 *     (i.e., no global variables)
 *   - does not make any use of character variables or arrays
 *   - does not read input or write output
 */
uint32_t PartitionInteger(uint32_t N, Ordering order);

#endif
