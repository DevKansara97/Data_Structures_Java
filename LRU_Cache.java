import java.util.*;

public class LRU_Cache {

    private int capacity, size;
    private Node head, tail;
    private Map<Integer, Node> mp;

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.mp = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    class Node {
        private int key, val;
        private Node prev, next;

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    void put(int key, int val) {

        if (mp.containsKey(key)) {
            Node curr = mp.get(key);
            curr.val = val;

            removeNode(curr);
            insertAtBeginning(curr);
            return;
        }

        
        // Cache is full:
        if (size == capacity) {
            mp.remove(tail.key);
            removeNode(tail);
            size--;
        }

        Node curr = new Node(key, val);
        mp.put(key, curr);

        // insert at beginning:
        insertAtBeginning(curr);

        size++;

    }

    int get(int key) {

        if (!mp.containsKey(key)) {
            return -1;
        }

        Node curr = mp.get(key);

        removeNode(curr);

        // insert at beginning:
        insertAtBeginning(curr);

        return curr.val;
    }

    // void removeTail() {
    // tail = tail.prev;
    // tail.next = null;
    // }

    void removeNode(Node curr) {
        // null <--> 1 <--> 2 <--> (7) <--> 10 <--> 4 <--> null
        if (curr.prev != null) {
            curr.prev.next = curr.next;
        } else {
            head = curr.next;
        }

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        } else {
            tail = curr.prev;
        }
    }

    void insertAtBeginning(Node curr) {

        curr.prev = null;
        curr.next = head;

        if (head != null) {
            head.prev = curr;
        } else {
            tail = curr;
        }

        head = curr;
    }

    public static void main(String[] args) {

        LRU_Cache cache = new LRU_Cache(5);

        cache.put(1, 5);
        cache.put(2, 7);
        cache.put(7, 4);
        cache.put(6, 2);
        cache.put(1, 5);
        cache.put(5,7);
        cache.put(4, 10);

        // cache.put(2, 7);
        // {
        // 1 : 5,
        // 2 : 7,
        // 7 : 4,
        // 6 : 2,
        // 1 : 5
        // }

        int val = cache.get(1);
        System.out.println(val);
    }
}
