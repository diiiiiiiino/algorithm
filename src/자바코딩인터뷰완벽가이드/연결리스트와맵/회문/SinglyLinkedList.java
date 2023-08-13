package 자바코딩인터뷰완벽가이드.연결리스트와맵.회문;

import java.util.Stack;

public final class SinglyLinkedList {
    private final class Node {
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

    public boolean isPalindrome() {
        Node fastRunner = head;
        Node slowRunner = head;

        Stack<Integer> firstHalf = new Stack<>();

        // 연결 리스트의 왼쪽 절반이 스택에 쌓입니다.
        while (fastRunner != null && fastRunner.next != null) {
            firstHalf.push(slowRunner.data);

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        // 요소 개수가 홀수라면 중간 노드를 건너 뛰어야 합니다.
        if (fastRunner != null) {
            slowRunner = slowRunner.next;
        }

        // 스택에서 값을 꺼내 연결 리스트의 오른쪽 절반의 노드와 비교합니다.
        while (slowRunner != null) {
            int top = firstHalf.pop();

            // 값이 일치하지 않으면 연결 리스트는 회문이 아닙니다.
            if (top != slowRunner.data) {
                return false;
            }

            slowRunner = slowRunner.next;
        }

        return true;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(2);
        sll.insertFirst(1);
        sll.insertFirst(4);
        sll.insertFirst(9);
        sll.insertFirst(4);
        sll.insertFirst(1);
        sll.insertFirst(2);

        /* 원서 예제 코드
        sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(9);
        sll.insertFirst(10);
        sll.insertFirst(11); */

        sll.print();
        boolean result = sll.isPalindrome();

        System.out.println("\nIs it palindrome? " + result);
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
}