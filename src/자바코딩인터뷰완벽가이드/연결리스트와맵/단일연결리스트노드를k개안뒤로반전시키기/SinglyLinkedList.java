package 자바코딩인터뷰완벽가이드.연결리스트와맵.단일연결리스트노드를k개안뒤로반전시키기;

public final class SinglyLinkedList {
    private final class Node {
        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void reverseInKGroups(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("A group cannot be 0 or negative");
        }

        if (head != null) {
            head = reverseInKGroups(head, k);
        }
    }

    private Node reverseInKGroups(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int counter = 0;

        while (current != null && counter < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

            counter++;
        }

        if (next != null) {
            head.next = reverseInKGroups(next, k);
        }

        return prev;
    }

    public void print() {
        System.out.println("\nHead (" + head + ") ----------> Last:");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(0);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(1);
        sll.insertFirst(3);
        sll.insertFirst(3);
        sll.insertFirst(4);
        sll.insertFirst(7);

        sll.print();
        sll.reverseInKGroups(3);
        sll.print();
    }
}