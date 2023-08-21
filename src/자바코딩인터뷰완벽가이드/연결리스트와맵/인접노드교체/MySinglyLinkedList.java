package 자바코딩인터뷰완벽가이드.연결리스트와맵.인접노드교체;

public class MySinglyLinkedList {
    private final class Node{
        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;
    private Node tail;

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    public void swap(){
        Node currentNode = head;
        Node prevNode = null;

        while(currentNode != null && currentNode.next != null){
            Node node1 = currentNode;
            Node node2 = currentNode.next;
            Node node3 = currentNode.next.next;

            node1.next = node3;
            node2.next = node1;

            if(prevNode == null){
                head = node2;
            } else {
                prevNode.next = node2;
            }

            if(currentNode.next == null){
                tail = currentNode;
            }

            prevNode = node1;
            currentNode = currentNode.next;
        }
    }

    public void print() {
        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        MySinglyLinkedList sll = new MySinglyLinkedList();

        // sll.insertFirst(11);
        sll.insertFirst(5);
        sll.insertFirst(8);
        sll.insertFirst(9);
        //sll.insertFirst(4);

        System.out.println("Linked list before swapping:");
        sll.print();

        sll.swap();

        System.out.println("\nLinked list after swapping:");
        sll.print();
    }
}
