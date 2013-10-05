package crackcode;
/**
 * 1.3 Design an algorithm and write code to remove the duplicate characters 
 * in a string without using any additional buffer. 
 * NOTE: One or two additional variables are fine. 
 * An extra copy of the array is not.
 * 
 * FOLLOW UP
 * Write the test cases for this method.
 */
public class ch1_3 {
    public static void removeDuplicatedChars(char[] str){
        int k = 0;
        for(int i = 0; i < str.length; i++){
            boolean duplicated = false;
            for(int j = 0; j < k; j++){
                if(str[i]==str[j]){
                    duplicated = true;
                    break;
                }
            }
            if(!duplicated){
                str[k++] = str[i];
            }
        }
        // in java, need to set 0 for all spaces
        for(int i = k; i < str.length; i++){
            str[i] = 0;
        }
    }
    public static void main(String[] args) {
        char str[] = {'a','b','c','d'};
        removeDuplicatedChars(str);
        System.out.println(str);
        
        char str1[] = {'a','b','c','d','e','a','b','b','f'};
        removeDuplicatedChars(str1);
        System.out.println(str1);
    }

}
