#include <stdio.h>
int
atoi(char* a){
	int value = 0;
	int sign = 1;
	if(*a == '-'){
		sign = -1;
		a++;
	}
	while(*a != (char)NULL){
		value *= 10;
		value += *a - '0';
		a++;
	}
	value *= sign;
	return value;
}

int main(){
	printf("%d\n", atoi((char*)"-123456"));
}
