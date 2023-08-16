package 자바코딩인터뷰완벽가이드.연결리스트와맵.회문;

import java.util.Stack;

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

    public boolean isPalindrome(){
        Node fastRunner = head;
        Node slowRunner = head;

        Stack<Integer> stack = new Stack<>();
        while(fastRunner != null && fastRunner.next != null){
            stack.push(slowRunner.data);
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        if(fastRunner != null){
            slowRunner = slowRunner.next;
        }

        while(slowRunner != null){
            int top = stack.pop();
            if(top != slowRunner.data){
                return false;
            }

            slowRunner = slowRunner.next;
        }

        return true;
    }

    public static void main(String[] args) {
        MySinglyLinkedList sll = new MySinglyLinkedList();

        sll.insertFirst(2);
        sll.insertFirst(1);
        sll.insertFirst(4);
        sll.insertFirst(9);
        sll.insertFirst(4);
        sll.insertFirst(1);

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