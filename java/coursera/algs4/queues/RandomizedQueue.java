import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue; // queue elements
    private int N = 0; // number of elements on queue

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the queue
    public int size() {
        return N;
    }

    // resize the underlying array
    private void resize(int max) {
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (N == queue.length)
            resize(2 * queue.length);
        queue[N] = item;
        N++;
        
        int idx = StdRandom.uniform(0, N);
        swap(queue, N-1, idx);
    }

    // delete and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        N--;
        Item item = queue[N];
        queue[N] = null;
        if (N > 0 && N == queue.length / 4)
            resize(queue.length / 2);
        return item;
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        return queue[StdRandom.uniform(0, N)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private void swap(Item[] a, int i, int j) {
        Item temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void suffle(Item[] a) {
        int size = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(0, size);
            swap(a, i, r);
        }
    }
    // an iterator, doesn't implement remove() since it's optional
    private class RandomizedQueueIterator implements Iterator<Item> {
        private int pos;
        private Item[] data;
        
        RandomizedQueueIterator() {
            pos = 0;
            data = (Item[]) new Object[N];
            for (int i = 0; i < N; i++) {
                data[i] = queue[i];
            }
            suffle(data);
        }

        public boolean hasNext() {
            return pos < N;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return data[pos++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        q.enqueue("e");
        q.enqueue("f");
        q.enqueue("g");
        q.enqueue("h");
        q.enqueue("i");
        q.enqueue("j");
        System.out.println("size: " + q.size());
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }

        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        q.enqueue("e");
        q.enqueue("f");
        q.enqueue("g");
        q.enqueue("h");
        q.enqueue("i");
        q.enqueue("j");
        System.out.println("size: " + q.size());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("size: " + q.size());
        q.enqueue("k");
        q.enqueue("l");
        q.enqueue("m");
        q.enqueue("n");
        q.enqueue("o");
        System.out.println("size: " + q.size());
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        for (int i = 0; i < 10; i++) {
            System.out.println("sample: " + q.sample());
        }
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }

        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        q.enqueue("e");
        q.enqueue("f");
        q.enqueue("g");
        q.enqueue("h");
        q.enqueue("i");
        q.enqueue("j");
        Iterator<String> itr = q.iterator();
        while (itr.hasNext()) {
            System.out.println("itr: " + itr.next());
        }

        for (String str : q) {
            System.out.println("iterable: " + str);
        }
        
        RandomizedQueue<Integer> q2 = new RandomizedQueue<Integer>();
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        for (int n : q2) {
            System.out.println(n);
        }
    }
}