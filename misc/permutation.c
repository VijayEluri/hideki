#include <stdio.h>
#include <string.h>

void swap(char* str, int a, int b)
{
    char tmp = str[a];
    str[a] = str[b];
    str[b] = tmp;
}

void 
permutation(char* str, int index)
{
    if(index == (int)strlen(str)){
        printf("%s\n", str);
        return;
    }

    for(int i = index; i < strlen(str); i++){
        swap(str, index, i);
        permutation(str, index+1);
        swap(str, index, i);
    }
}

int 
main(int argc, char** argv){
    char str[] = "abc"; 
    permutation(str, 0);
}