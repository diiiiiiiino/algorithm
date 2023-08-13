package 자바코딩인터뷰완벽가이드.연결리스트와맵.뒤에서n번째노드;

public class SinglyLinkedList {
    private final class Node{
        private int data;
        private Node next;
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

    public int nthToLastIterative(int n){
        if(n <= 0){
            throw new IllegalArgumentException("The given n index is out of bounds");
        }

        Node firstRunner = head;
        Node secondRunner = head;

        for(int i = 0; i < n; i++){
            if(firstRunner == null){
                throw new IllegalArgumentException("The given n index is out of bounds");
            }

            firstRunner = firstRunner.next;
        }

        while(firstRunner != null){
            firstRunner = firstRunner.next;
            secondRunner = secondRunner.next;
        }

        return secondRunner.data;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        SinglyLinkedList sll2 = new SinglyLinkedList();

        sll1.insertFirst(7);
        sll1.insertFirst(3);
        sll1.insertFirst(8);
        sll1.insertFirst(9);
        sll1.insertFirst(5);
        sll1.insertFirst(1);
        sll1.insertFirst(2);

        int n1 = 5;
        int resultIterative1 = sll1.nthToLastIterative(n1);

        System.out.println("\nIterative: The " + n1 + "th to last node has the value: " + resultIterative1);

        int n2 = 1;
        int resultIterative2 = sll2.nthToLastIterative(n2);

        System.out.println("\nIterative: The " + n2 + "th to last node has the value: " + resultIterative2);
    }
}
