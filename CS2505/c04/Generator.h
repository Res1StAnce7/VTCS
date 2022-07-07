#ifndef GENERATOR_H
#define GENERATOR_H
#include <stdint.h>
#include <stdio.h>

#define NPATTERNS 5

struct _patternPair {
   uint32_t pOffset;
   uint8_t  pLength;
};
typedef struct _patternPair patternPair;

uint8_t* genDataBlock( uint32_t Length );
void writeDataBlock(FILE* Out, uint8_t* dataBlock, uint32_t Length);

#endif
