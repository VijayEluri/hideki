import java.util.Arrays;

public class ThreeSum
{

    public static void threeSum(int[] arr, int target){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int twoTarget = target - arr[i];
            int j = i + 1;
            int k = arr.length - 1;
            while(j < k){
                int twoSum = arr[j] + arr[k];
                if(twoSum == twoTarget){
                    System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
                    return;
                }
                else if(twoSum < twoTarget){
                    j++;
                }
                else{
                    k--;
                }

            }
        }
        System.out.println("Unable to find");
    }
    public static void main(String[] args){
        int[] arr = {3, 5, 7, 9, 15, 20, 6, 11, 19}; 
        threeSum(arr, 32);
    }
}