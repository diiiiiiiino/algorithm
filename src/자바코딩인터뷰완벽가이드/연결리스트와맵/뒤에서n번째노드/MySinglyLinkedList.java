package 자바코딩인터뷰완벽가이드.연결리스트와맵.뒤에서n번째노드;

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
        Node firstRunner = head;
        Node secondRunner = head;

        for(int i = 0; i < n; i++){
            if(firstRunner == null){
                throw new IllegalArgumentException();
            }

            firstRunner = firstRunner.next;
        }

        while(firstRunner != null){
            firstRunner = firstRunner.next;
            secondRunner = secondRunner.next;
        }

        return secondRunner.data;
    }

    public void print(){
        System.out.println("Head ( " + head + " ) ---------> Last ( " + tail + " ):");
        Node node = head;
        while(node != null){
            System.out.print(node);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySinglyLinkedList sll1 = new MySinglyLinkedList();

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

        /*int n2 = 1;
        int resultIterative2 = sll2.nthToLastIterative(n2);

        System.out.println("\nIterative: The " + n2 + "th to last node has the value: " + resultIterative2);*/
    }
}
