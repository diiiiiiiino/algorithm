package 자바코딩인터뷰완벽가이드.연결리스트와맵.연결리스트재배열;

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

    public void rearrange(int data){
        Node currentNode = head;

        Node prevNode = null;
        while(currentNode != null){
            Node nextNode = currentNode.next;

            if(currentNode.data < data){
                if(currentNode == head){
                    currentNode = nextNode;
                    continue;
                } else if(currentNode == tail){
                    tail = prevNode;
                }

                prevNode.next = currentNode.next;
                currentNode.next = head;
                head = currentNode;
            } else {
                prevNode = currentNode;
            }

            currentNode = nextNode;
        }
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

        sll1.insertFirst(3);
        sll1.insertFirst(2);
        sll1.insertFirst(1);
        sll1.insertFirst(5);
        sll1.insertFirst(8);
        sll1.insertFirst(7);
        sll1.insertFirst(6);

        sll1.print();
        sll1.rearrange(5);
        sll1.print();

        /*
        sll2.print();
        sll2.rearrange(7);
        sll2.print(); */
    }
}
