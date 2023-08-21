package 자바코딩인터뷰완벽가이드.연결리스트와맵.단일연결리스트노드를k개안뒤로반전시키기;

public final class MySinglyLinkedList {
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
        Node currentNode = head;
        Node prevNode = null;
        Node nextNode = null;
        int count = 0;

        while(currentNode != null && count < k){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;

            count++;
        }

        if(nextNode != null){
            head.next = reverseInKGroups(nextNode, k);
        }

        return prevNode;
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
        MySinglyLinkedList sll = new MySinglyLinkedList();

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