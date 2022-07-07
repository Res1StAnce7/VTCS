/** CS 2505 Spring 2022:  Intersection.c
 * 
 *  Supplied framework for Intersecting Rectangles project.  Your task is to
 *  complete the supplied code to satisfy the posted specification for this
 *  assignment.  
 * 
 *  Student:   Siliang Zhang
 *  PID:       s589z417
 */
#include "Intersection.h"

// DO NOT MODIFY THIS FILE IN ANY WAY!! //
 
#include <stdlib.h>       // generally useful

// Declarations for helper functions should go here:
int32_t* locate(int32_t x1, int32_t y1, int32_t x2, int32_t y2,
                int32_t x3, int32_t y3, int32_t x4, int32_t y4);

/**  Determines whether two rectangles, A and B, intersect, computes the attributes
 *   of the intersection (if any), and returns true or false accordingly.
 *
 *   Pre:
 *         aSWx and aSWy specify the SW (lower, left) corner of A
 *         aHeight specifies the vertical dimension of A
 *         aWidth specifies the horizontal dimension of A
 *         bSWx and bSWy specify the SW (lower, left) corner of B
 *         bHeight specifies the vertical dimension of B
 *         bWidth specifies the horizontal dimension of B
 *         iSWx and iSWy point to variables the client will use to store the
 *              SW corner of the intersection, if it exists
 *         iHeight and iWidth point to variables the client will use to store
 *              the height and width of the intersection, if it exists
 *       
 *   Returns:
 *         true if A and B share at least one point; false otherwise
 */
bool Intersection(int32_t aSWx, int32_t aSWy, int32_t aHeight, int32_t aWidth,
                  int32_t bSWx, int32_t bSWy, int32_t bHeight, int32_t bWidth,
                  int32_t* const iSWx, int32_t* const iSWy, int32_t* const iHeight, int32_t* const iWidth)
{
   int32_t *arr = locate(aSWx, aSWy, aSWx + aWidth, aSWy + aHeight,
                         bSWx, bSWy, bSWx + bWidth, bSWy + bHeight);

   if (arr[0] > arr[2] || arr[1] > arr[3]) 
   {
      *iWidth = 0;
      *iHeight = 0;

      return false;
   }
   *iSWx = arr[0];
   *iSWy = arr[1];
   *iWidth = arr[2] - arr[0];
   *iHeight = (arr[1] == arr[5]) ? 0 : (arr[3] - arr[1]);

   return true;
}

int32_t* locate(int32_t const x1, int32_t const y1, int32_t const x2, int32_t const y2,
                int32_t const x3, int32_t const y3, int32_t const x4, int32_t const y4)
{
   int32_t x5 = (x1 > x3) ? x1 : x3;
   int32_t y5 = (y1 > y3) ? y1 : y3;
   int32_t x6 = (x2 < x4) ? x2 : x4;
   int32_t y6 = (y2 < y4) ? y2 : y4;
   int32_t arr[] = {x5, y5, x6, y6, x5, y6, x6, y5};
   int32_t *ptr = arr;

   return ptr;
}
