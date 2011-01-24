
public class OddMan{
	public static void main(String[] argv){
		int[] array = {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1};
		int oddMan = 0;
		for(int i = 0; i < array.length; i++){
			oddMan ^= array[i];
		}
		System.out.println("OddMan=" + oddMan);
	}
}
