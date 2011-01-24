
/**
  4 3 5 2 3 5 7 5

  4 3 3 2 2 2 2 2

  0 0 2 0 1 3 5 3
*/
#include <stdio.h>


int
main(int argc, char* argv[]){
	int array[] = {4, 3, 5, 2, 3, 5, 7, 5};
	int size = sizeof(array)/sizeof(int);
	int lowest = 0;
	int max = 0;
	for(int i = 0; i < size; i++){
		if(i == 0 || lowest > array[i]){
			lowest = array[i];
		}
		if(array[i] - lowest > max){
			max = array[i] - lowest;
		}
	}
	printf("max return => %d\n", max);
	return 0;
}
