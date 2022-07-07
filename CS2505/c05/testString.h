#ifndef TEST_STRING_H
#define TEST_STRING_H
#include "String.h"
#include <inttypes.h>
#include <stdio.h>
#include <stdbool.h>

bool testStringCreate(uint32_t* const ptsEarned, uint32_t* const ptsPossible);
bool testStringCompare(uint32_t* const ptsEarned, uint32_t* const ptsPossible);
bool testStringCat(uint32_t* const ptsEarned, uint32_t* const ptsPossible);
bool testStringCopy(uint32_t* const ptsEarned, uint32_t* const ptsPossible);
bool testStringStrstr(uint32_t* const ptsEarned, uint32_t* const ptsPossible);
bool testStringSubstring(uint32_t* const ptsEarned, uint32_t* const ptsPossible);
bool testStringErase(uint32_t* const ptsEarned, uint32_t* const ptsPossible);

// Returns a randomly-selected C-string... you can use this for your own testing.
char* getString();

#endif
