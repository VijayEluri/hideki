#include <stdio.h>
#include <math.h>
#include <string.h>

int atoi(char* a){
    int sign = 1;
    if(*a == '-'){
        sign = -1;
        a++;
    }
    int i = 0;
    while(*a != (int)NULL){
        i = i * 10 + (*a - '0');
        a++;
    }
    return i * sign;
}

int stringmultiply(char* param1, char* param2)
{
    return atoi(param1) * atoi(param2);
}
int stringmultiply2(char* param1, char* param2)
{   
    int result = 0;
    for(int i = strlen(param2) - 1; i >= 0; i--){
        int param2temp = param2[i] - '0';
        int temp = 0;
        for(int j = strlen(param1) - 1; j >= 0; j--){
            int param1temp = param1[j] - '0';
            temp +=  param2temp * param1temp  * pow(10, strlen(param1) - 1 - j);
        }
        result += (temp * pow(10, strlen(param2) - 1 - i));
    }
    return result;
}
int 
main(int argc, char** argv){
    printf("%d\n", stringmultiply("123", "45")); // 5535
    printf("%d\n", stringmultiply2("123", "45")); // 5535
}