package 자바코딩인터뷰완벽가이드.연결리스트와맵.이중연결리스트반전시키기;

public final class MyDoublyLinkedList {
    private final class Node {
        private int data;
        private Node next;
        private Node prev;

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

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    public void reverse(){
        Node currentNode = head;
        Node prevNode = null;

        while(currentNode != null){
            Node prev = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = prev;

            prevNode = currentNode;

            currentNode = currentNode.prev;
        }

        if(prevNode != null){
            head = prevNode;
        }
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
        MyDoublyLinkedList dll = new MyDoublyLinkedList();

        dll.insertFirst(122);
        dll.insertFirst(4);
        dll.insertFirst(7);
        dll.insertFirst(-2);
        dll.insertFirst(2);
        dll.insertFirst(21);
        dll.insertFirst(22);

        System.out.println("\nInitial:");
        dll.print();

        dll.reverse();

        System.out.println("\nReversed:");
        dll.print();
    }
}