#include <stdio.h>
#include <math.h>

int sqrt1(int n){
	int val;
	for(val = 0; ;val++){
		if(val * val == n){
			return val;
		}
		else if(val*val > n){
			return val - 1;
		}
	}
}

int main(int argc, char* argv[]){
	int i;
	for(i = 0; i <= 20; i++){
		printf("sqrt1(%d) = %d\n", i, sqrt1(i));
	}
}
