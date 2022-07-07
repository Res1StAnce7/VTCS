#ifndef TESTCODE_H
#define TESTCODE_H
#include <stdio.h>
#include <stdint.h>

void testShowBytesAtOffset(uint8_t* dBlock, uint32_t Length);
void testShowValueAtOffset(uint8_t* dBlock, uint32_t Length);
void testFindOccurrencesOfByte(uint8_t* dBlock, uint32_t Length);
void testFindOccurrencesOfSequence(uint8_t* dBlock, uint32_t Length);
void testCopyBlock(uint8_t* dBlock, uint32_t Length);
void testBlendBytes(uint8_t* dBlock, uint32_t Length);

void writePoints(FILE* Out, uint8_t Pts);

#endif
