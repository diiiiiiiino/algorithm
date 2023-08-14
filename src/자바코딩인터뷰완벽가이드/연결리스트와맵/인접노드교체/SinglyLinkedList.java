package 자바코딩인터뷰완벽가이드.연결리스트와맵.인접노드교체;

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

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    public void swap() {
        if (head == null || head.next == null) {
            return;
        }

        Node currentNode = head;
        Node prevPair = null;

        // 한 번에 2개의 노드를 고려하여 링크를 교환합니다.
        while (currentNode != null && currentNode.next != null) {
            Node node1 = currentNode;           // 첫 번째 노드
            Node node2 = currentNode.next;      // 두 번째 노드
            Node node3 = currentNode.next.next; // 세 번째 노드

            // 첫 번째 노드 node1과 두 번째 노드 node2를 교체합니다.
            Node auxNode = node1;
            node1 = node2;
            node2 = auxNode;

            // 링크를 교체하여 복구합니다.
            node1.next = node2;
            node2.next = node3;

            // 첫 번째 교체라면 머리 노드를 설정합니다.
            if (prevPair == null) {
                head = node1;
            } else {
                // 이전 쌍을 현재 쌍에 연결합니다.
                prevPair.next = node1;
            }

            // 더 이상 노드가 없으므로 꼬리 노드를 설정합니다.
            if (currentNode.next == null) {
                tail = currentNode;
            }

            // 현재 쌍의 이전 노드를 prevPair에 설정합니다.
            prevPair = node2;

            // 다음 쌍을 설정해 링크를 복구합니다.
            currentNode = node3;
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
        SinglyLinkedList sll = new SinglyLinkedList();

        // sll.insertFirst(11);
        sll.insertFirst(5);
        sll.insertFirst(8);
        sll.insertFirst(9);
        sll.insertFirst(4);

        System.out.println("Linked list before swapping:");
        sll.print();

        sll.swap();

        System.out.println("\nLinked list after swapping:");
        sll.print();
    }
}
