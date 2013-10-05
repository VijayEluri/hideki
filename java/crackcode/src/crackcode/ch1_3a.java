package crackcode;

import java.util.HashSet;
import java.util.Set;

public class ch1_3a {
    public static void removeDuplicatedChars(char[] str){
        Set<Character> s = new HashSet<Character>();
        for(int i = 0; i < str.length; i++){
            char c = str[i];
            if(s.contains(c)){
                str[i] = 0;
            }
            else{
                s.add(c);
            }
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
