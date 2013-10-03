package crackcode;

import java.util.Arrays;

/**
 * 1.1 Implement an algorithm to determine if a string has all unique
 * characters. What if you can not use additional data structures?
 */
public class ch1_1 {
    public static boolean isAllUnique(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == array[i+1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAllUnique("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(isAllUnique("abcdefghijklmneopqrstuvwxyz"));
    }
}
