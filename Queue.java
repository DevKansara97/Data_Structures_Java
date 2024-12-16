// Implementation of Queue

import java.util.*;

public class Queue {

    static class Queue_Array {

        static int arr[];
        static int size;
        static int rear = -1;

        public Queue_Array(int size) {
            arr = new int[size];
            this.size = size;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static boolean isFull() {
            return size == rear - 1;
        }

        // O(1)
        public static void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue Full...");
                return;
            }

            arr[++rear] = data;
        }

        // O(n)
        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Empty Queue...");
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            rear--;
            return front;
        }

        // O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue...");
                return -1;
            }

            return arr[0];
        }
    }

    static class Circular_Queue_Array {

        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;

        public Circular_Queue_Array(int size) {
            arr = new int[size];
            this.size = size;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // O(1)
        public static void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue Full...");
                return;
            }

            // Adding first element:
            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // O(1)
        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Empty Queue...");
                return -1;
            }

            int result = arr[front];

            // Single element removal:
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        // O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue...");
                return -1;
            }

            return arr[front];
        }
    }

    static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class Queue_LinkedList {

        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // O(1)
        public static void enqueue(int val) {
            Node newNode = new Node(val);
            if (isEmpty()) {
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // O(1)
        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Empty Queue...");
                return -1;
            }

            int result = head.val;
            if (head == tail) {
                tail = null;
            }
            head = head.next;

            return result;
        }

        // O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue...");
                return -1;
            }

            return head.val;
        }
    }

    static class Queue_TwoStacks {

        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // O(n)
        public static void enqueue(int val) {
            while (!s1.isEmpty()) {
                s2.push(s1.peek());
                s1.pop();
            }

            s1.push(val);

            while (!s2.isEmpty()) {
                s1.push(s2.peek());
                s2.pop();
            }
        }

        // O(1)
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Empty Queue...");
                return -1;
            }

            int temp = s1.peek();
            s1.pop();
            return temp;
        }
    }

    public static void main(String[] args) {
        // Queue_Array q = new Queue_Array(10);
        // Queue_LinkedList q = new Queue_LinkedList();
        // Circular_Queue_Array q = new Circular_Queue_Array(2);
        Queue_TwoStacks q = new Queue_TwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " ");
        }

    }
}
