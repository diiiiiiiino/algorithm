package 자바코딩인터뷰완벽가이드.연결리스트와맵.연결리스트2개의합;

public class MySinglyLinkedList {
    private final class Node {
        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;

    public void insertFirst(int data){
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void sum(MySinglyLinkedList sll){
        MySinglyLinkedList sllResult = new MySinglyLinkedList();

        Node node = sum(head, sll.head, 0);

        sllResult.head = node;

        sllResult.reverseLinkedList(sllResult.head);

        sllResult.print();
    }

    private Node sum(Node node1, Node node2, int carry){
        if(node1 == null && node2 == null && carry == 0){
            return null;
        }

        int value1 = 0;
        if(node1 != null){
            value1 = node1.data;
        }

        int value2 = 0;
        if(node2 != null){
            value2 = node2.data;
        }

        int sum = value1 + value2 + carry;

        Node node = new Node();
        node.data = sum % 10;

        if(node1 != null || node2 != null){
            node.next = sum(node1 == null ? null : node1.next, node2 == null ? null : node2.next, sum > 10 ? 1 : 0);
        }

        return node;
    }

    private Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node remaining = reverseLinkedList(node.next);

        node.next.next = node;
        node.next = null;

        head = remaining;

        return remaining;
    }

    public void print(){
        System.out.println("\nResult:");

        Node currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        MySinglyLinkedList sll1 = new MySinglyLinkedList();
        /*sll1.insertFirst(2);
        sll1.insertFirst(1);
        sll1.insertFirst(4);*/
        sll1.insertFirst(9);
        sll1.insertFirst(8);
        sll1.insertFirst(3);
        sll1.insertFirst(7);

        MySinglyLinkedList sll2 = new MySinglyLinkedList();
        sll2.insertFirst(4);
        sll2.insertFirst(8);
        sll2.insertFirst(9);
        sll2.insertFirst(7);

        sll1.sum(sll2);
    }
}
