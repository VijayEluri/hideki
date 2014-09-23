#include <stdio.h>

// divide without using + - * /
unsigned int divide(unsigned int dividend, unsigned int divisor)
{
    unsigned int answer = 0;
    while(dividend > divisor){
        dividend -= divisor;
        answer++;
    }
    return answer;
}

// divide without using + - * /
unsigned int divide2(unsigned int dividend, unsigned int divisor)
{
    unsigned int denom = divisor;
    unsigned int current = 1;
    unsigned int answer = 0;

    if(denom > dividend)  return 0;
    if(denom == dividend) return 1;

    while(denom <= dividend){
        denom   <<= 1;
        current <<= 1;
    }
    denom   >>= 1;
    current >>= 1;

    while(current != 0){
        if(dividend >= denom){
            dividend -= denom;
            answer |= current;
        }
        denom   >>= 1;
        current >>= 1;  
    }

    return answer;
}

int main(int argc, char** argv){
    printf("972 / 5 = %d\n", divide(972, 5)); // 194
    printf("972 / 5 = %d\n", divide2(972, 5)); // 194
}