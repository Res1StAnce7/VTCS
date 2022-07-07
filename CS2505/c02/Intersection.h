#ifndef INTERSECTION_H
#define INTERSECTION_H

// DO NOT MODIFY THIS FILE IN ANY WAY!! //

#include <stdint.h>     // for exact-width integer types
#include <stdbool.h>    // for bool type

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
                  int32_t* const iSWx,  int32_t* const iSWy, 
                  int32_t* const iHeight, int32_t* const iWidth);

#endif
