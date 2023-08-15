package 자바코딩인터뷰완벽가이드.연결리스트와맵.마지막노드를머리노드로만들기;

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

    public void moveLastToFront1() {
        if (head == null || head.next == null) {
            throw new IllegalArgumentException("Linked list cannot be null or with a single node");
        }

        Node currentNode = head;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        Node nextNode = currentNode.next;

        currentNode.next = null;

        nextNode.next = head;
        head = nextNode;
    }

    public void moveLastToFront2() {
        if (head == null || head.next == null) {
            throw new IllegalArgumentException("Linked list cannot be null or with a single node");
        }

        Node currentNode = head;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next.next = head;

        head = currentNode.next;

        currentNode.next = null;
    }

    public void print() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}