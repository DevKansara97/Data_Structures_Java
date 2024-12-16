// Linked List Implementation of Stack

public class StackClass {

    static class Node {

        int data;
        Node next;

        public Node() {
            this.next = null;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static class Stack {

        public static Node head;
        private static int length;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            length++;
            Node newNode = new Node(data); // newNode = Node(data, head)
            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }

            int top = head.data;
            head = head.next;
            length--;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
