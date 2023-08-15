package 자바코딩인터뷰완벽가이드.연결리스트와맵.중복노드제거;

import java.util.HashSet;
import java.util.Set;

public class MySinglyLinkedList {

    private final class Node{
        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " " ;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if(tail == null){
            tail = newNode;
        }
        size++;
    }

    public void removeDuplicates1(){
        Set<Integer> set = new HashSet<>();

        Node currentNode = head;
        Node prevNode = null;
        while(currentNode != null){
            if(set.contains(currentNode.data)){
                prevNode.next = currentNode.next;

                if(currentNode == tail){
                    tail = prevNode;
                }

                size--;
            } else {
                set.add(currentNode.data);
                prevNode = currentNode;
            }

            currentNode = currentNode.next;
        }
    }

    public void removeDuplicates2() {
        Node currentNode = head;

        while(currentNode != null){
            Node pointerNode = currentNode;

            while(pointerNode.next != null){
                if(currentNode.data == pointerNode.next.data){
                    pointerNode.next = pointerNode.next.next;

                    if(pointerNode.next == tail){
                        tail = pointerNode;
                    }
                    size--;
                } else {
                    pointerNode = pointerNode.next;
                }
            }

            currentNode = currentNode.next;
        }
    }

    private int size() {
        return size;
    }

    private void print() {
        System.out.println("Head (  " + head + "  )  ---------> Last (  " + tail + "  ):");
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySinglyLinkedList sll1 = new MySinglyLinkedList();
        MySinglyLinkedList sll2 = new MySinglyLinkedList();
        // SinglyLinkedList sll3 = new SinglyLinkedList();

        // removeDuplicates1 관련 연결 리스트
        sll1.insertFirst(7);
        sll1.insertFirst(5);
        sll1.insertFirst(5);
        sll1.insertFirst(1);

        // removeDuplicates2 관련 연결 리스트
        sll2.insertFirst(7);
        sll2.insertFirst(4);
        sll2.insertFirst(5);
        sll2.insertFirst(3);
        sll2.insertFirst(5);
        sll2.insertFirst(1);

       /* 원서 예제 코드
       sll3.insertFirst(5);
       sll3.insertFirst(2);
       sll3.insertFirst(12);
       sll3.insertFirst(2);
       sll3.insertFirst(12);
       sll3.insertFirst(5);
       sll3.insertFirst(5);
       sll3.insertFirst(12);
       sll3.insertFirst(1);
       sll3.insertFirst(4);
       sll3.insertFirst(12); */

        System.out.println("\nLinked list before removing duplicates:");
        sll1.print();
        sll1.removeDuplicates1();
        System.out.println("\nLinked list after removing duplicates:");
        sll1.print();

        System.out.println("\nSize: " + sll1.size());

        System.out.println("\nLinked list before removing duplicates:");
        sll2.print();
        sll2.removeDuplicates2();
        System.out.println("\nLinked list after removing duplicates:");
        sll2.print();

        System.out.println("\nSize: " + sll2.size());

       /*
       System.out.println("\nLinked list before removing duplicates:");
       sll3.print();
       sll3.removeDuplicates1();
       // sll3.removeDuplicates1();
       System.out.println("\nLinked list after removing duplicates:");
       sll3.print();

       System.out.println("\nSize: " + sll3.size()); */
    }


}
