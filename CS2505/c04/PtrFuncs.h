#ifndef PTRSTUFF_H
#define PTRSTUFF_H
#include <stdio.h>
#include <stdint.h>

///  DO NOT MODIFY THIS FILE IN ANY WAY!!  ///

/**  Enumerated type used in interface of showValue()
 */
enum _Sign {SIGNED, UNSIGNED};
typedef enum _Sign Sign;

/**  Uses pointer-based logic to access a specified portion of a region of
 *   memory and prints the corresponding bytes to a supplied file stream.
 *   The bytes are separated by one or more spaces, and the last byte is
 *   followed by a newline character, just as in the example function.
 * 
 *   Pre: Out is open on a file
 *        baseAddr points to the first byte of the memory region
 *        Offset is the index of the first relevant byte of the memory region
 *        nBytes is the number of bytes to be printed
 *   Restrictions:
 *      You must use only pointer syntax in accessing the data.  You may not
 *      use array bracket notation for any reason whatsoever.
 */
void showBytesAtOffset(FILE* Out, const uint8_t* const baseAddr, 
		       uint16_t Offset, uint8_t nBytes);



/**  Uses pointer-based logic to display a specified portion of a region
 *   of memory, using pointer typecasts to control the number of bytes 
 *   that are displayed, and the way those bytes are interpreted.
 * 
 *   Pre:   Out is open on a file
 *          baseAddr points to the first byte of the memory region
 *          Offset is the location, relative to baseAddr, of the first
 *             relevant byte of the memory region
 *          Sgn indicates whether the bytes are to be interpreted as
 *             representing a signed or unsigned integer
 *          nByte is 1, 2, 4 or 8
 *   Restrictions:
 *      You must use only pointer syntax in accessing the data.  You may not
 *      use array bracket notation for any reason whatsoever.
 */
void showValueAtOffset(FILE* Out, const uint8_t* const baseAddr, uint32_t Offset, 
                                  Sign Sgn, uint8_t nBytes);


/**  Uses pointer-based logic to search a specified portion of a region
 *   of memory for occurrences of a specified one-byte value.  When a
 *   matching byte is found, the offset of that occurrence (relative to
 *   the base address) is written, in hexadecimal.
 * 
 *   Pre:   Out is open on a file
 *          baseAddr points to the first byte of the memory region
 *          Length is number of bytes in the memory region
 *          Byte is the value to be found
 *   Restrictions:
 *      You must use only pointer syntax in accessing the data.  You may not
 *      use array bracket notation for any reason whatsoever.
 */
void findOccurrencesOfByte(FILE* Out, const uint8_t* const baseAddr, 
                           uint32_t Length, uint8_t Byte);

/**  Uses pointer-based logic to search a specified portion of a region of
 *   memory for occurrences of a specified sequence of bytes.
 * 
 *   Pre:   Out is open on a file
 *          baseAddr points to the first byte of the memory region
 *          Length is number of bytes in the memory region
 *          Sequence points to a copy of the sequence to be found
 *          sLength is the number of bytes in the sequence
 *   Restrictions:
 *      You must use only pointer syntax in accessing the data.  You may not
 *      use array bracket notation for any reason whatsoever.
 */
void findOccurrencesOfSequence(FILE* Out, const uint8_t* const baseAddr, 
			       uint32_t Length, const uint8_t* const Sequence,
			       uint32_t sLength);


/**  Uses pointer-based logic to copy a specified portion of a region of
 *   memory to replace the bytes in another portion of that memory region.
 * 
 *   Pre:   baseAddr points to the first byte of the memory region
 *          Source and Destination point to the first bytes of two sections
 *             of the memory region that contains Length bytes
 *          The regions pointed to by Source and Destination do not overlap
 *   Post:  Length bytes, beginning at *Source, have been copied to Length
 *             consecutive locations, beginning at *Destination
 *   Restrictions:
 *      You must use only pointer syntax in accessing the data.
 */
void copyBlock(const uint8_t* const baseAddr, uint32_t Source, 
                              uint32_t Destination, uint32_t Length);


/**  Uses pointer-based logic to modify the contents of a specified portion
 *   of a region of memory, by bitwise blending with bytes of another
 *   portion of that memory region.
 * 
 *   Pre:   Out is open on a file
 *          baseAddr points to the first byte of the memory region
 *          First and Second point to the first bytes of two sections
 *             of the memory region that each contain Length bytes
 *          The regions pointed to by First and Second do not overlap
 *   Post:  Length bytes, beginning at *Second, have been blended with Length
 *             bytes, beginning at *First; the blending is accomplished as
 *             follows: the k-th byte of *Second is modified by XORing its
 *             hi nybble with the low nybble of the k-th byte from *First,
 *             and its low nybble with the hi nybble of the k-th byte from
 *             *First.
 *   Restrictions:
 *      You must use only pointer syntax in accessing the data.
 */
void blendBytes(const uint8_t* const First, uint8_t* const Second, uint32_t Length);



#endif
