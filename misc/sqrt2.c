/**
 * square root by newton method
 */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

static double eps = 0.000001;

double
_sqrt(double y){
    double x1 = 1.0f;
    double x0 = 1.0f;
    while(abs(y - x1) > eps){
        x1 = x0 - (x0**2 - y)/(2 * x0); 
    }
    return x1;
}

int 
main(int argc, char** argv){
    if(argc != 2){
        fprintf(stderr, "Usage: sqrt2 <number>\n");
        return -1;
    }
    double x = atof(argv[1]);
    double test = _sqrt(x);
    double correct = sqrt(x);
    fprintf(stdout, "%.6f\n", test);
    fprintf(stdout, "%.6f\n", correct);
    return 0;
}