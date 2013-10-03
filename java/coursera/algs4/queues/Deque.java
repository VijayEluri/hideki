import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Dequeue. A double-ended queue or deque (pronounced "deck") is a
 * generalization of a stack and a queue that supports inserting and removing
 * items from either the front or the back of the data structure. Create a
 * generic data type Deque that implements the following API:
 */
public class Deque<Item> implements Iterable<Item> {
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
        
        Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // insert the item at the front
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();

        Node node = new Node(item);
        if (size == 0) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
        size++;
    }

    // insert the item at the end
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException();

        Node node = new Node(item);
        if (size == 0) {
            first = node;
            last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node node = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = node.next;
            first.prev = null;
        }
        size--;
        return node.item;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node node = last;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = node.prev;
            last.next = null;
        }
        size--;
        return node.item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new IteratorImpl();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class IteratorImpl implements Iterator<Item> {
        private Node current;

        IteratorImpl() {
            current = first;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void dump() {
        Iterator<Item> itr = iterator();
        System.out.println("size: " + size());
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Deque<String> q = new Deque<String>();
        q.addFirst("c");
        q.dump();
        q.addFirst("b");
        q.dump();
        q.addFirst("a");
        q.dump();
        q.addLast("x");
        q.dump();
        q.addLast("y");
        q.dump();
        q.addLast("z");
        q.dump();
        System.out.println("q.removeFirst(): " + q.removeFirst());
        q.dump();
        System.out.println("q.removeLast(): " + q.removeLast());
        q.dump();
        q.addFirst("start");
        q.dump();
        q.addLast("end");
        q.dump();
        System.out.println("q.removeFirst(): " + q.removeFirst());
        q.dump();
        System.out.println("q.removeFirst(): " + q.removeFirst());
        q.dump();
        System.out.println("q.removeLast(): " + q.removeLast());
        q.dump();
        System.out.println("q.removeLast(): " + q.removeLast());
        q.dump();
        System.out.println("q.removeLast(): " + q.removeLast());
        q.dump();
        System.out.println("q.removeLast(): " + q.removeLast());
        q.dump();
    }
}