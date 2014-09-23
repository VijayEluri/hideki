/**
 * square root by divide conqure
 */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

static double thresh = 0.000001;

int is_almost_equal(double value, double target){
    return (target - thresh <= value && value <= target + thresh) ? 1 : 0;
}

double
__sqrt(double x, double min, double max){
    double mid = (min + max) / 2.0;
    double value = mid * mid;
    if(is_almost_equal(value, x)){
        return mid;
    }
    else if (value > x){
        return __sqrt(x, min, mid);
    }
    else{
        return __sqrt(x, mid, max);
    }
}

double
_sqrt(double x){
    return __sqrt(x, 0.0, x);
}



int 
main(int argc, char** argv){
    if(argc != 2){
        fprintf(stderr, "Usage: sqrt <number>\n");
        return -1;
    }
    double x = atof(argv[1]);
    double test = _sqrt(x);
    double correct = sqrt(x);
    fprintf(stdout, "%.6f\n", test);
    fprintf(stdout, "%.6f\n", correct);
    return 0;
}