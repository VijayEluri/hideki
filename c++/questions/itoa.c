#include <stdio.h>
#include <string.h>


char* reverse(char* str){
	int len = strlen(str);
	int i;
	for(i = 0; i < len/2; i++){
		char tmp = str[i];
		str[i] = str[len - i - 1];
		str[len - i - 1] = tmp;
	}
	return str;
}

char* itoa(int num){
	static char buffer[BUFSIZ];
	buffer[0] = 0;
	char* buf = buffer;
	int sign = 1;
	if(num < 0 ){
		sign = -1;
		num *= -1;
	}
	for(;num != 0; num /= 10){
		*buf++ = (num % 10) + '0';
	}
	if(sign == -1){
		*buf++ = '-';
	}
	*buf = 0;
	reverse(buffer);
	return buffer;
}

int main(int argc, char** argv){
	if (argc != 2){
		fprintf(stderr, "Usage: %s <numbers>\n", argv[0]);
		return -1;
	}
	int num = atoi(argv[1]);
	fprintf(stdout, "itoa(%d) = %s\n", num, itoa(num));
	return 0;
}
