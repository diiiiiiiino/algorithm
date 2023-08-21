package 자바코딩인터뷰완벽가이드.연결리스트와맵.정렬된연결리스트2개병합;

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

    public void merge(MySinglyLinkedList sll){
        if(sll == null){
            return;
        }

        Node list1;
        Node list2;

        if(head.data > sll.head.data){
            list2 = head;
            head = sll.head;
            list1 = sll.head;
        } else {
            list1 = head;
            list2 = sll.head;
        }

        while(list1 != null && list1.next != null){
            if(list1.next.data > list2.data){
                Node nextNode = list1.next;
                list1.next = list2;
                list2 = nextNode;
            }

            list1 = list1.next;
        }

        if(list1.next == null){
            list1.next = list2;
        }
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
        MySinglyLinkedList sll1 = new MySinglyLinkedList();

        sll1.insertFirst(4);
        sll1.insertFirst(3);
        sll1.insertFirst(2);
        sll1.insertFirst(1);

        MySinglyLinkedList sll2 = new MySinglyLinkedList();

        sll2.insertFirst(8);
        sll2.insertFirst(7);
        sll2.insertFirst(6);
        sll2.insertFirst(5);

        sll1.print();
        sll2.print();

        sll1.merge(sll2);

        System.out.println("\nAfter merging:");

        sll1.print();
    }
}