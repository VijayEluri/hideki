/**
 * merge two arrays / merge sort
 */

#include<stdio.h>
#define MAX 50

void merge(int *arr, int low, int mid, int high)
{
    printf("low = %d, mid = %d, high = %d\n", low, mid, high);
    int tmp[MAX];
    int i = low; 
    int j = mid + 1;
    int k = low; // index for tmp
    while(i <= mid && j <= high){
        if(arr[i] <= arr[j]){
            tmp[k] = arr[i];
            i++;
        }
        else{
            tmp[k] = arr[j];
            j++;
        }
        k++;
    }
    while(i <= mid){
        tmp[k++] = arr[i++];
    }
    while(j <= high){
        tmp[k++] = arr[j++];
    }    

    for(k = low; k <= high; k++){
        arr[k] = tmp[k];
    }
}
void
mergesort(int *arr, int low, int high){
    // base case
    if(low < high){
        int mid = (low + high) / 2;
        // left
        mergesort(arr, low, mid);
        // right
        mergesort(arr, mid + 1, high);
        // merge
        merge(arr, low, mid, high);
    }
}

int 
main(int argc, char** argv){
    int i;
    int n;
    int arr[MAX];

    printf("Enter the total number of elements: ");
    scanf("%d",&n);

    printf("Enter the elements which to be sort: ");
    for(i = 0; i < n; i++){
         scanf("%d",&arr[i]);
    }
    for(i=0; i < n; i++){
         printf("%d ",arr[i]);
    }
    printf("\n");

    mergesort(arr, 0, n - 1);

    printf("After merge sorting elements are: ");
    for(i = 0; i < n; i++){
         printf("%d ",arr[i]);
    }
    printf("\n");

   return 0;
}