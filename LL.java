
public class LL {

    Node head;
    private int size;

    LL() {
        this.size = 0;
    }

    class Node {

        String val;
        Node next;

        Node(String val) {
            this.val = val;
            this.next = null;
            size++;
        }

        Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // add - first
    public void addFirst(String val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    // add - last
    public void addLast(String val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        } else if (head.next == null) {
            head.next = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    // print list
    public void printList() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.val + " -> ");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    // delete first
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        head = head.next;
    }

    // delete last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;
    }

    // reverse (Iterative)
    public void reverseIterative() {

        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head, currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    // reverse (Recursive)
    public Node reverseRecursive(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head; // Logic
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        LL list = new LL();

        list.addFirst("a");
        list.addFirst("is");
        list.printList();

        list.addLast("this");
        list.printList();
        list.deleteLast();

        list.addFirst("this");
        list.addLast("list");
        list.printList();

        list.reverseIterative();
        list.printList();

        list.head = list.reverseRecursive(list.head);
        list.printList();

        System.out.println(list.size);
    }

}
