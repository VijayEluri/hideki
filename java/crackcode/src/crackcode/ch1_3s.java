package crackcode;

public class ch1_3s {
    public static void removeDuplicates(char[] str) {
        if (str == null)
            return;
        int len = str.length;
        if (len < 2)
            return;
        int tail = 1;

        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j])
                    break;
            }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        
        // 1) this does not work if original string does not contain duplication
        // 2) in java, set null to end of string does not work like C language 
        // str[tail] = 0;
        
        // in java, need to set 0 for all spaces
        for(int i = tail; i < str.length; i++){
            str[i] = 0;
        }
    }

    public static void removeDuplicatesEff(char[] str) {
        if (str == null)
            return;
        int len = str.length;
        if (len < 2)
            return;
        boolean[] hit = new boolean[256];
        for (int i = 0; i < 256; ++i) {
            hit[i] = false;
        }
        hit[str[0]] = true;
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            if (!hit[str[i]]) {
                str[tail] = str[i];
                ++tail;
                hit[str[i]] = true;
            }
        }
        // 1) this does not work if original string does not contain duplication
        // 2) in java, set null to end of string does not work like C language 
        // str[tail] = 0;
        
        // in java, need to set 0 for all spaces
        for(int i = tail; i < str.length; i++){
            str[i] = 0;
        }
    }
   
    public static void main(String[] args) {
        char str[] = {'a','b','c','d'};
        removeDuplicates(str);
        System.out.println(str);
        
        char str1[] = {'a','b','c','d','e','a','b','b','f'};
        removeDuplicates(str1);
        System.out.println(str1);
        
        char str2[] = {'a','b','c','d'};
        removeDuplicatesEff(str2);
        System.out.println(str2);
        
        char str3[] = {'a','b','c','d','e','a','b','b','f'};
        removeDuplicatesEff(str3);
        System.out.println(str3);
    }
}
