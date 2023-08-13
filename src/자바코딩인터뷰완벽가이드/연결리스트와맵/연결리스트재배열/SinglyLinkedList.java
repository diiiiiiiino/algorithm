package 자바코딩인터뷰완벽가이드.연결리스트와맵.연결리스트재배열;

public class SinglyLinkedList {
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

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if(tail == null){
            tail = newNode;
        }
    }

    public void rearrange(int n){
        Node currentNode = head;
        head = currentNode;
        tail = currentNode;

        while(currentNode != null){
            Node nextNode = currentNode.next;

            if(currentNode.data < n ){
                currentNode.next = head;
                head = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
            }

            currentNode = nextNode;
        }

        tail.next = null;
    }

    public void print(){
        Node currentNode = head;

        System.out.println("Head (" + head + ") ---------> Last (" + tail + " ): ");
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        SinglyLinkedList sll2 = new SinglyLinkedList();

        sll1.insertFirst(9);
        sll1.insertFirst(3);
        sll1.insertFirst(2);
        sll1.insertFirst(1);
        sll1.insertFirst(5);
        sll1.insertFirst(8);
        sll1.insertFirst(7);
        sll1.insertFirst(6);

        /* 원서 예제 코드
        sll2.insertFirst(11);
        sll2.insertFirst(10);
        sll2.insertFirst(9);
        sll2.insertFirst(8);
        sll2.insertFirst(8);
        sll2.insertFirst(8);
        sll2.insertFirst(7);
        sll2.insertFirst(6);
        sll2.insertFirst(5);
        sll2.insertFirst(4);
        sll2.insertFirst(-3);
        sll2.insertFirst(2);
        sll2.insertFirst(1);
        sll2.insertFirst(11);
        sll2.insertFirst(90); */

        sll1.print();
        sll1.rearrange(5);
        sll1.print();

        /*
        sll2.print();
        sll2.rearrange(7);
        sll2.print(); */
    }
}
