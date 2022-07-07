#include "arrayList.h"
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include <stdio.h>

// Declare any static helper functions here:

/**  Creates a new, empty arrayList object such that:
 * 
 *      - capacity equals dimension
 *      - elemSz equals the size (in bytes) of the data objects the user
 *        will store in the arrayList
 *      - data points to a block of memory large enough to hold capacity
 *        user data objects
 *      - usage is zero
 *      - the user's comparison function is correctly installed
 *      - the user's clean function is correctly installed, if provided

 *   Returns:  new arrayList object
 */
arrayList* AL_create(uint32_t dimension, uint32_t elemSz, 
                     int32_t (*compareElems)(const void* const pLeft, const void* const pRight),
                     void (*cleanElem)(void* const pElem)){
   arrayList* list = malloc(sizeof(arrayList));
   list->elemSz = elemSz;
   list->data = calloc(dimension, elemSz);
   list->capacity = dimension;
   list->usage = 0;
   list->compareElems = compareElems;
   list->cleanElem = cleanElem;
   	
	return list;
}

/**  Inserts the user's data object into the arrayList.
 * 
 *   Pre:     *pAL is a proper arrayList object
 *            *pElem is a valid user data object
 *   Post:    a copy of the user's data object has been inserted, at the
 *            position defined by the user's compare function
 *   Returns: true unless the insertion fails (unlikely unless it's not
 *            possible to increase the size of the arrayList
 */
bool AL_insert(arrayList* const pAL, const void* const pElem){
	if (pAL->usage == 0){
      memcpy(pAL->data, pElem, pAL->elemSz);
      pAL->usage++;
   }else{
      int insert = 0;
      if (pAL->usage == pAL->capacity){
         pAL->capacity *= 2;
         pAL->data = realloc(pAL->data, pAL->capacity * pAL->elemSz);
      }
      for (uint32_t i = 0; i < pAL->usage; i++){
         if (pAL->compareElems(pElem, pAL->data + (i * pAL->elemSz)) <= 0){
            insert = 1;
            memmove(pAL->data + ((i + 1) * pAL->elemSz), pAL->data + (i * pAL->elemSz), (pAL->usage - i) * (pAL->elemSz));
            memcpy(pAL->data + (i * pAL->elemSz), pElem, pAL->elemSz);
            break;
         }
      }
      if (insert == 0){
         memcpy(pAL->data + (pAL->usage * pAL->elemSz), pElem, pAL->elemSz);
      }
      pAL->usage++;
   }
   return true;
}

/**  Removes the data object stored at the specified index.
 * 
 *   Pre:      *pAL is a proper arrayList object
 *             index is a valid index for *pAL
 *   Post:     the element at index has been removed; succeeding elements
 *             have been shifted forward by one position; *pAL is proper
 *   Returns:  true unless the removal failed (most likely due to an
 *             invalid index)
 */
bool AL_remove(arrayList* const pAL, uint32_t index){
	if (pAL->usage == 0 || index >= pAL->usage){
      return false;
   }else if (index == pAL->usage - 1){
      pAL->cleanElem(pAL->data + (index * pAL->elemSz));
   }else{
      memmove(pAL->data + (index * pAL->elemSz), pAL->data + ((index + 1) * pAL->elemSz), (pAL->usage - index) * (pAL->elemSz));
      pAL->usage--;
   }
   return true;
}

/**  Searches for a matching object in the arrayList.
 * 
 *   Pre:      *pAL is a proper arrayList object
 *             *pElem is a valid user data object
 *   Returns:  pointer to a matching data object in *pAL; NULL if no
 *             match can be found
 */
void* AL_find(const arrayList* const pAL, const void* const pElem){
   for(uint32_t i = 0; i < pAL->usage; i++){
      if (pAL->compareElems(pElem, pAL->data + (i * pAL->elemSz)) == 0){
         return pAL->data + (i * pAL->elemSz);
      }
   }
	return NULL;
}

/**  Returns pointer to the data object at the given index.
 * 
 *   Pre:      *pAL is a proper arrayList object
 *             indexis a valid index for *pAL
 *   Returns:  pointer to the data object at index in *pAL; NULL if no
 *             such data object exists
 */
void* AL_elemAt(const arrayList* const pAL, uint32_t index){
   if (index < pAL->usage && pAL->usage > 0 && pAL->data != NULL){
      return pAL->data + (index * pAL->elemSz);
   }
   
   return NULL;
}

/**  Deallocates all dynamic content in the arrayList, including any
 *   dynamic content in the user data objects in the arrayList.
 * 
 *   Pre:   *pAL is a proper arrayList object
 *   Post:  the data array in *pAL has been freed, as has any dynamic
 *          memory associated with the user data objects that were in
 *          that array (via the user-supplied clean function); all the
 *          fields in *pAL are set to 0 or NULL, as appropriate.
 */
void AL_clean(arrayList* const pAL){
   for (uint32_t i = 0; i < pAL->usage; i++){
      pAL->cleanElem(pAL->data + (i * pAL->elemSz));
   }
   free(pAL->data);
   pAL->data = NULL;
   pAL->compareElems = NULL;
   pAL->cleanElem = NULL;
   pAL->elemSz = 0;
   pAL->capacity = 0;
   pAL->usage = 0;
}

// Implement static helper functions below:

