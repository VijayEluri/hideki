#include <stdio.h>


int atoi(char* str){
	int sign = 1;
	int number = 0;
	if(*str == '-'){
		sign = -1;
		str++;
	}
	for( ; *str != 0; str++){
		number = number * 10 + (*str - '0');
	}
	return sign * number;
}

int main(int argc, char** argv){
	if (argc != 2){
		fprintf(stderr, "Usage: %s <numbers>\n", argv[0]);
		return -1;
	}
	fprintf(stdout, "atoi(%s) = %d\n", argv[1], atoi(argv[1]));
	return 0;
}
