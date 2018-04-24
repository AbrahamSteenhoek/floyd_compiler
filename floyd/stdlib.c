// ----------------------------------------------------------------------
// File: stdlib.c
// Runtime support library for Floyd
// ----------------------------------------------------------------------

#include <stdlib.h>
#include "stdlib.h"

// ----------------------------------------------------------------------
// Integer Comparison Functions
// ----------------------------------------------------------------------
int gte(int op1, int op2) {
    if(op2 >= op1)
        return -1;
    else
        return 0;
}

int gt(int op1, int op2) {
    if(op2 > op1)
        return -1;
    else
        return 0;
}

int equals(int op1, int op2) {
    if(op1 == op2)
        return -1;
    else
        return 0;
}

// ----------------------------------------------------------------------
// Null-Checker function
// ----------------------------------------------------------------------

void nullpointertest(int lineno, void* ptr) {

  if (ptr == NULL) {
    
    write(1, "Null pointer exception on line ", 32);
    writeint(lineno);
    exit(0);
  }
}


// ----------------------------------------------------------------------
// I/O Management Functions
// ----------------------------------------------------------------------

// writes <ch> to standard output (<out> is the predefined Floyd Writer object)
void Writer_io_write(void *out, int ch) {
  char c = ch;
  
  write(1, &c, 1);  
}

void writeint(int num) {
  char buf[20];
  char result[20] = "0\n";
  char *pos = buf;
  char *writeptr = result;
  int numWritten;
 
  // Handle negative numbers
  if (num < 0) {
    *writeptr++ = '-';
    num = -num;
  }
  
  if (num > 0) {
      
    // Build the number in reverse order
    while (num > 0) {
      *pos++ = (num % 10) + '0';
      num /= 10;
    }
    pos--;
    
    // Now we need to copy the results into the output buffer, reversed
    while (pos > buf) {
      *writeptr++ = *pos--;
    }
    *writeptr++ = *pos;
    *writeptr++ = 10;
    *writeptr++ = 0;
  } else {
    // number is 0; use default result
    writeptr = result + 3;
  }
  
  write(1, result, (writeptr - result) - 1);
  
}


// reads a character from stdin and returns it (<in> is the predefined Floyd Reader object)
int Reader_io_read(void *in) {
  char c;

  read(0, &c, 1);

  return c;
}

// ----------------------------------------------------------------------
// String Management Functions
// ----------------------------------------------------------------------

// Constructs and returns an Floyd String using chars in <lit>, which must be null terminated
struct String *string_fromlit(char *lit)
{
  struct String *newstr = (struct String *)calloc(sizeof(struct String), 1);
  struct CharNode *cur = NULL;
  while (*lit) {
    struct CharNode *node = (struct CharNode *)calloc(sizeof(struct CharNode), 1);
    node->ch = *lit;
    if (cur == NULL) {
      newstr->list = node;
    } else {
      cur->next = node;
    }
    cur = node;
    lit++;
  }
  return newstr; 
}

