/**
 * n-th Fibonacci number
 */

#include <stdio.h>
#include <stdlib.h>

long fibonacci(int n){
    // base cases
    if(n == 0)
        return 0;
    if(n == 1)
        return 1;

    return fibonacci(n - 1) + fibonacci(n - 2);
}

int 
main(int argc, char** argv){
    if(argc != 2){
        fprintf(stderr, "Usage: fibonacci <nth>\n");
        return -1;
    }
    int n = atof(argv[1]);
    long test = fibonacci(n);
    fprintf(stdout, "%ld\n", test);
    return 0;
}