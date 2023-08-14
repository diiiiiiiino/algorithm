package 자바코딩인터뷰완벽가이드.연결리스트와맵.중복경로제거;

public class SinglyLinkedList {
    private final class Node{
        private int r;
        private int c;
        private Node next;

        @Override
        public String toString() {
            return " (" + r + ", " + c + ") ";
        }
    }

    private Node head;
    private Node tail;

    public void insertFirst(int r, int c){
        Node newNode = new Node();

        newNode.r = r;
        newNode.c = c;
        newNode.next = head;
        head = newNode;

        if(tail == null){
            tail = newNode;
        }
    }

    public void removeRedundantPath(){
        Node currentNode = head;

        while(currentNode.next != null && currentNode.next.next != null){
            Node middleNode = currentNode.next.next;

            if(currentNode.c == currentNode.next.c && currentNode.c == middleNode.c){
                currentNode.next = middleNode;
            } else if(currentNode.r == currentNode.next.r && currentNode.r == middleNode.r){
                currentNode.next = middleNode;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    public void print(){
        System.out.println("\nHead (" + head + ") --------> Last (" + tail + "):");

        Node currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(3, 4);
        sll.insertFirst(3, 3);
        sll.insertFirst(3, 2);
        sll.insertFirst(2, 2);
        sll.insertFirst(1, 2);
        sll.insertFirst(0, 2);
        sll.insertFirst(0, 1);
        sll.insertFirst(0, 0);

        System.out.println("\nInitial");
        sll.print();

        sll.removeRedundantPath();
        System.out.println("\nAfter");
        sll.print();
    }
}
