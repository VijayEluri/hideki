package crackcode;
/**
 * 1.2 Write code to reverse a C-Style String. 
 * (C-String means that “abcd” is represented as five characters, including the null character.)
 */       
public class ch1_2 {
    public static void reverse(char str[]){
        for(int i = 0; i < str.length/2; i++){
            char tmp = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = tmp;
        }
    }
    public static void main(String[] args) {
        char str[] = {'a','b','c','d'};
        reverse(str);
        System.out.println(str);
        
        char str1[] = {'a','b','c','d','e'};
        reverse(str1);
        System.out.println(str1);
    }

}
