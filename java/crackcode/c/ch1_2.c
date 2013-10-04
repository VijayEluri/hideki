#include <stdio.h>
void reverse(char* str){
	char* start = str;
	char* end = str;

	while(*end != (char)NULL){
		end++;
	}
	end--;

	while(start < end){
		char tmp = *start;
		*start = *end;
		*end = tmp;
		start++;
		end--;
	}
}

int main(int argc, char** argv){
	char str[] = "abcd";
	reverse(str);
	printf("%s\n", str);
	char str1[] = "abcde";
	reverse(str1);
	printf("%s\n", str1);
	return 0;
}