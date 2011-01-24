#include <stdio.h>
#include <math.h>

int sqrt3(int n){
	return _sqrt3(n, 0, n);
}

int _sqrt3(int n, int min, int max){
	if(min > max){
		return max;
	}

	int half = (min + max) / 2;
	int tmp = half * half;
	if(tmp == n){
		return half;
	}else if(tmp > n){
		return _sqrt3(n, min, half - 1);
	}else if(tmp < n){
		return _sqrt3(n, half + 1, max);
	}
}

int main(int argc, char* argv[]){
	int i;
	for(i = 0; i <= 20; i++){
		printf("sqrt3(%d) = %d\n", i, sqrt3(i));
	}
}
