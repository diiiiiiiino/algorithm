package 자바코딩인터뷰완벽가이드.연결리스트와맵.교차연결리스트;

import java.util.Random;

public class SinglyLinkedList {
    private final class Node{
        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private final class PairNode {
        private final Node head;
        private final Node tail;

        public PairNode(Node head, Node tail){
            this.head = head;
            this.tail = tail;
        }
    }

    private Node head;
    private Node tail;

    public int intersection(){
        PairNode pair = generateTwoLinkedListWithInterection();

        Node currentNode1 = pair.head;
        Node currentNode2 = pair.tail;

        int s1 = linkedListSize(currentNode1);
        int s2 = linkedListSize(currentNode2);

        if (s1 > s2) {
            for (int i = 0; i < (s1 - s2); i++) {
                currentNode1 = currentNode1.next;
            }
        } else {
            for (int i = 0; i < (s2 - s1); i++) {
                currentNode2 = currentNode2.next;
            }
        }

        while (currentNode1 != null && currentNode2 != null) {
            if (currentNode1 == currentNode2) {
                return currentNode1.data;
            }

            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }

        return -1;
    }

    private PairNode generateTwoLinkedListWithInterection() {
        // 1개에서 10개 노드 사이의 리스트에 대해 임의 크기를 선택합니다.
        int size1 = new Random().nextInt(10) + 1;
        int size2 = new Random().nextInt(10) + 1;
        int size3 = new Random().nextInt(10) + 1;

        PairNode firstList = generateLinkedList(size1);
        PairNode secondList = generateLinkedList(size2);

        PairNode commonList = generateLinkedList(size3);

        // 교차점에 더미 값 설정
        commonList.head.data = 9999;

        // 교차점 생성
        firstList.tail.next = commonList.head;
        secondList.tail.next = commonList.head;

        System.out.println("\nFirst linked list size: " + (size1 + size3));
        print(firstList.head, commonList.tail);

        System.out.println("\nSecond linked list size: " + (size2 + size3));
        print(secondList.head, commonList.tail);

        return new PairNode(firstList.head, secondList.head);
    }

    private PairNode generateLinkedList(int size) {
        head = null;
        tail = null;

        for (int i = 1; i <= size; i++) {
            Node newNode = new Node();

            newNode.data = i;
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
        }

        return new PairNode(head, tail);
    }

    private int linkedListSize(Node head) {
        Node currentNode = head;
        int count = 0;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }

        return count;
    }

    private void print(Node head, Node tail) {
        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
