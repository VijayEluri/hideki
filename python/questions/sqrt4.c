#include <stdio.h>
#include <math.h>

// http://snippets.dzone.com/posts/show/2715
// http://en.wikipedia.org/wiki/Integer_square_root

int sqrt4(int n){
	int i = 0;
	while(n >= 2 * i + 1){
		n -= (2 * i++) + 1;
	}
	return i;
}

int main(int argc, char* argv[]){
	int i;
	for(i = 0; i <= 20; i++){
		printf("sqrt4(%d) = %d\n", i, sqrt4(i));
	}
}
