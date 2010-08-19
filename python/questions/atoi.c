#include <stdio.h>
#include <string.h>

/**
 * 4 Bytes => 32 Bits
 * 31 bits without sign
 */
int power(int base, int exponent){
	int val = 1;
	int i;
	for(i = 0; i < exponent; i++){
		val *= base;
	}
	return val;
}
int max_int_val(){
	return power(2, 30) * 2 - 1;
}
int max_int_digits(){
	int digits = 1;
	int max_val = max_int_val();
	while(1){
		max_val = max_val / 10;
		if(max_val > 0){
			digits++;
		}
		else{
			break;
		}
	}
	return digits;
}

int atoi(const char* ascii){
	int max_digits = max_int_digits() - 1;

	int value = 0;
	int idx = 0;
	int sign = 1;
	if(ascii[idx] == '-'){
		sign = -1;
		idx++;
	}

	if(strlen(ascii + idx) > max_digits){
		printf("It may cause overflow.");
		return 0;
	}

	int i;
	for(i = idx; i < strlen(ascii); i++){
		value = value * 10 + (ascii[i] - '0');
	}
	value *= sign;
	return value;
}

int
main(int argc, char*argv[]){
	printf("sizeof(int) = %ld\n", sizeof(int));
	printf("max = %d\n", max_int_val());
	printf("max digits = %d\n", max_int_digits());
	printf("atoi(0)    =  %d\n", atoi("0"));
	printf("atoi(1)    =  %d\n", atoi("1"));
	printf("atoi(-1)   =  %d\n", atoi("-1"));
	printf("atoi(123)  =  %d\n", atoi("123"));
	printf("atoi(-321) =  %d\n", atoi("-321"));
	printf("atoi(999999999)   =  %d\n", atoi("999999999"));
	printf("atoi(-999999999)  =  %d\n", atoi("-999999999"));
	printf("atoi(1000000000)  =  %d\n", atoi("1000000000"));
	printf("atoi(-1000000000) =  %d\n", atoi("-1000000000"));
	printf("atoi(2147483647)  =  %d\n", atoi("2147483647"));
	printf("atoi(-2147483647) =  %d\n", atoi("-2147483647"));
	printf("atoi(9999999999)  =  %d\n", atoi("9999999999"));
	printf("atoi(-9999999999) =  %d\n", atoi("-9999999999"));
}
