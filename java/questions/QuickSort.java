
public class QuickSort{
	private static void swap(int[] array, int x, int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	private static int partition(int[] array, int first, int last){
		int pivot = array[(first + last)/2];
		int i = first - 1;
		int j = last  + 1;
		while(true){
			do{
				i++;
			}while(array[i] < pivot);
			do{
				j--;
			}while(array[j] > pivot);
			if(i < j)
				swap(array, i, j);
			else
				return j;

		}
	}
	static void qsort(int[] array, int first, int last){
		int split = partition(array, first, last);
		if(first < split)
			qsort(array, first, split);
		if(last > split + 1)
			qsort(array, split+1, last);
	}
	static void quickSort(int[] array){
		qsort(array, 0, array.length - 1);
	}
	public static void main(String[] args){
		int[] array = {10, 5 , 4 , 88, 99, 1, 9, 23, 75, 100, 234, 55};
		quickSort(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}
}
