CC = gcc
CFLAGS = -std=c11 -o prog -Wall -Wextra -ggdb3 -no-pie
 
c05: c07driver.c
	$(CC) $(CFLAGS) $(LIBS) checkAnswer.o Generator.o c07driver.c Untangle.c 

clean:
	rm prog
	rm *.txt
	rm *.bin