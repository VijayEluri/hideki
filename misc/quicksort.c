#include <stdio.h>
#include <stdlib.h>

#define N 12

void swap(int *arr, int a, int b)
{
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
}
void
print(int* arr, int left, int right){
    for(int i = left; i <= right; i++){
        printf("%d ", arr[i]);
    }
    printf("\n");    
}
int 
pertition(int* arr, int left, int right){

    int pivot =  arr[(left + right)/2];
    printf("pivot [%d] => %d\n", (left + right)/2, pivot);
    int i = left - 1;
    int j = right + 1;
    while(1){
        do{
            i++;
        }while(arr[i] < pivot);
        do{
            j--;
        }while(arr[j] > pivot);
        if(i < j)
            swap(arr, i, j);
        else{
            print(arr, left, right);
            printf("split --> %d\n",j);
            return j; // arr[j] = end of left array
        }
    }
}
void 
quicksort(int* arr, int left, int right){
    int split = pertition(arr, left, right);
    if(left < split)
        quicksort(arr, left, split); // left sub array
    if(right > split + 1)
        quicksort(arr, split + 1, right); // right sub array
}



int
main(int argc, char** argv)
{
    int arr[N] = {19, 39, 3, 33, 4, 30, 98, 83, 77, 5, 0, 40};
    print(arr, 0, N - 1);
    quicksort(arr, 0, N - 1);
    print(arr, 0, N - 1);
}