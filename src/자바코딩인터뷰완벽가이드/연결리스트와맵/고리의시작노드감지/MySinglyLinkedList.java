package 자바코딩인터뷰완벽가이드.연결리스트와맵.고리의시작노드감지;

import java.util.Random;

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
    private int size;

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }

        size++;
    }

    public void generateLoop() {
        if (size < 2) {
            throw new RuntimeException("The linked list size must be at least 2");
        }

        Node currentNode = head;
        int rnd = new Random().nextInt(size - 1);

        for (int i = 0; i < rnd; i++) {
            currentNode = currentNode.next;
        }

        System.out.println("The generated loop starts at the node with value: " + currentNode);

        // 반복 실행 생성
        tail.next = currentNode;
    }

    public void findLoopStartNode(){
        Node slowRunner = head;
        Node fastRunner = head;

        while(fastRunner != null && fastRunner.next != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if(fastRunner == slowRunner){
                break;
            }
        }

        if(fastRunner == null || fastRunner.next == null){
            return;
        }

        slowRunner = head;

        while(slowRunner != fastRunner){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
    }

    public void print() {
        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        MySinglyLinkedList sll = new MySinglyLinkedList();

        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(7);
        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(3);
        sll.insertFirst(2);
        sll.insertFirst(1);
        sll.insertFirst(0);

        sll.generateLoop();
        sll.print();

        sll.findLoopStartNode();
    }
}
