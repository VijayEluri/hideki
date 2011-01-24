 

/**

  1 0 0 0 

& 0 1 1 1
---------
  0 0 0 0

 */

#include <stdio.h>
#include <stdlib.h>

int
main(int argc, char* argv[]){
	if(argc != 2){
		fprintf(stderr, "Usage: %s number\n", argv[0]);
		return -1;
	}

	int x = atoi(argv[1]);
	int y = x - 1;
	if ((x & y) == 0){
		fprintf(stdout, "%d is a power of 2\n", x);
	}
	else{
		fprintf(stdout, "%d is NOT a power of 2\n", x);
	}
	return 0;
}
