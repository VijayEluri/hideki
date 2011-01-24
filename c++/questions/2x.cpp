#include <stdio.h>
#include <stdlib.h>


int main(int argc, char* argv[]){
	if(argc != 2){
		fprintf(stderr, "Usage: %s exponent\n", argv[0]);
		return -1;
	}
	int exponent = atoi(argv[1]);
	int power = 1<< exponent;
	fprintf(stdout, "2^%d=%d\n", exponent, power);
	return 0;
}
