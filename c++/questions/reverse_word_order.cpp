#include<stdio.h>
#include<string.h>

void reverse(char* text, int start, int end){
	//printf("[%s] %d - %d\n", text, start, end);
	for(int i = start; i < (start + end)/2; i++){
		char c = text[i];
		text[i] = text[start+ end - 1 - i];
		text[start + end - 1 - i] = c;
	}
}

void reverse_word_order(char* text){
	int len = strlen(text);
	reverse(text, 0, len);
	int start = 0;
	for(int i = 0; i < len;i++){
		if(text[i] == ' '){
			reverse(text, start, i);
			start = i + 1;
		}
	}
	reverse(text, start, len);

}

int main(int argc, char *argv[])
{
	char buff[BUFSIZ];
	for(int i = 1; i < argc; i++){
		if(i != 1){
			strcat(buff, " ");
		}
		strcat(buff, argv[i]);
	}
	reverse_word_order(buff);
	printf("[%s]\n", buff);
}
