package crackcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.1 Implement an algorithm to determine if a string has all unique
 * characters. What if you can not use additional data structures?
 */
public class ch1_1s {
    public static boolean isAllUnique(String str) {
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < str.length(); i++){
            Character c = str.charAt(i);
            if(set.contains(c)){
                return false;
            }
            else{
                set.add(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAllUnique("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(isAllUnique("abcdefghijklmneopqrstuvwxyz"));
    }
}
