#include "PartitionInteger.h"
#include <math.h>

/**  Computes a new integer from N by separating all the even digits
 *   digits from N and all the odd digits from N. 
 * 
 * For example:
 *  {23410, EVENHIGH} --> 24031
 *  {23410, ODDHIGH}  --> 31240
 *  {2640, ODDHIGH}   --> 2640
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
uint32_t PartitionInteger(uint32_t N, Ordering order) 
{
   uint32_t digit;
   uint32_t length_odds = 0;
   uint32_t length_evens = 0;
   uint32_t odds = 0;
   uint32_t evens = 0;

   while (N != 0)
   {
      digit = N % 10;
      N = (N - digit) / 10;

      if (digit % 2 != 0)
      {
         for (uint32_t j = 0; j < length_odds; j++)
         {
            digit = digit * 10;
         }
         odds += digit;
         length_odds++;
      }
      else
      {
         for (uint32_t j = 0; j < length_evens; j++)
         {
            digit = digit * 10;
         }
         evens += digit;
         length_evens++;
      }
   }

   if (order == EVENHIGH)
   {
      for (uint32_t i = 0; i < length_odds; i++)
      {
         evens *= 10;
      }
      return evens + odds;
   }
   for (uint32_t i = 0; i < length_evens; i++)
   {
      odds *= 10;
   }
   return odds + evens;
} 
