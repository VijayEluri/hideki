#include <stdio.h>
#include <math.h>

#define N 1000

#define TRUE 1
#define FALSE 0

void prime(int n, int primes[]){
    primes[0] = FALSE;
    primes[1] = FALSE;
    for(int i = 2; i < n; i++){
        primes[i] = TRUE;
    }
    int limit = sqrt(n);
    for(int i = 2; i < limit; i++){
        if(primes[i] == TRUE)
            for(int j = i * i; j < n; j += i)
                primes[j] = FALSE;
    }
}

int 
main(int argc, char** argv){
    if(argc != 1){
        fprintf(stderr, "Usage: prime\n");
        return -1;
    }
    
    int primes[N];
    prime(N, primes);
    for(int i = 0; i < N; i++){
        if(primes[i] == TRUE)
            fprintf(stdout, "%d ", i);
    }
    fprintf(stdout, "\n");
    return 0;
}