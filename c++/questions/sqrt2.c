#include <stdio.h>
#include <math.h>

int sqrt2(int n){
	return sqrt_2(n, 0, n);
}

int sqrt_2(int n, int left, int right){
	int left2   = left   * left;
	int right2  = right  * right;
	if(left2 == n)  return left;
	if(right2 == n) return right;

	int middle = (left + right) / 2;
	int middle2 = middle * middle;
	if(middle2 == n) return middle;


	if(left2 < n && n < middle2){
		return sqrt_2(n, left + 1, middle - 1);
	}else if(middle2 < n && n < right2){
		return sqrt_2(n, middle + 1, right - 1);
	}else if(n < left2){
		return left - 1;
	}else if(n > right2){
		return right;
	}

}

int main(int argc, char* argv[]){
	int i;
	for(i = 0; i <= 20; i++){
		printf("sqrt2(%d) = %d\n", i, sqrt2(i));
	}
}
