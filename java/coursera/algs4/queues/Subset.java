public class Subset {



    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void suffle(String[] a) {
        for (int i = 0; i < a.length; i++) {
            int idx = StdRandom.uniform(i, a.length);
            swap(a, i, idx);
        }
    }

    private static void print(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Subset <k>");
            return;
        }
        int k = Integer.parseInt(args[0]);
        String[] array = new String[k];
        int total = 0;
        
        
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (total < k) {
                array[total] = str;
                total++;
                if (total == k) {
                    suffle(array);
                }
            }
            else {
                total++;
                int idx = StdRandom.uniform(0, total);
                if (idx < k) {
                    array[idx] = str;
                }
            }
        }
        Subset.print(array);

    }
}