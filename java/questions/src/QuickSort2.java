
public class QuickSort2 {
	public static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static int partition(int[] array, int left, int right){
		int pivot = array[(left + right)/2];
		int i = left - 1;
		int j = right + 1;
		while(true){
			do{
				i++;
			}while(array[i] < pivot);
			do{
				j--;
			}while(array[j]>pivot);
			if (i < j){
				swap(array, i, j);
			}
			else{
				return j;
			}
		}

	}
	
	public static void qsort(int[] array, int left, int right){
		int split = partition(array, left, right);
		if (left < split)
			qsort(array, left, split);
		if (split + 1 < right)
			qsort(array, split + 1, right);
	}
	public static void quickSort(int[] array){
		qsort(array, 0, array.length - 1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 10, 5, 4, 88, 99, 1, 9, 23, 75, 100, 234, 55 };
		quickSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println();

	}

}
