package 자바코딩인터뷰완벽가이드.연결리스트와맵.정렬된연결리스트2개병합;

public final class RecursionSinglyLinkedList {
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

    public void merge(RecursionSinglyLinkedList sll) {
        if(sll == null) {
            throw new IllegalArgumentException("Cannot merge null linked list");
        }

        head = merge(head, sll.head);
    }

    private Node merge(Node list1, Node list2) {
        if(list1 == null){
            return list2;
        } else if(list2 == null) {
            return list1;
        }

        Node node;
        if(list1.data < list2.data){
            list1.next = merge(list1.next, list2);
            node = list1;
        } else {
            list2.next = merge(list1, list2.next);
            node = list2;
        }

        return node;
    }

    public void print() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        RecursionSinglyLinkedList sll1 = new RecursionSinglyLinkedList();

        sll1.insertFirst(10);
        sll1.insertFirst(8);
        sll1.insertFirst(7);
        sll1.insertFirst(4);

        RecursionSinglyLinkedList sll2 = new RecursionSinglyLinkedList();

        sll2.insertFirst(11);
        sll2.insertFirst(9);
        sll2.insertFirst(5);

        sll1.print();
        sll2.print();

        sll1.merge(sll2);

        System.out.println("\nAfter merging:");

        sll1.print();
    }
}