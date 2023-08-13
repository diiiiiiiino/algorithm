package 자바코딩인터뷰완벽가이드.연결리스트와맵.중복노드제거;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList<T> {
    private final class Node<T>{
        private T data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    Node<T> head;
    Node<T> tail;
    int size;

    public void insertFirst(T data){
        Node<T> node = new Node<>();
        node.data = data;

        if(head == null){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }

        size++;
    }

    public void removeDuplicates1(){
        Set<T> set = new HashSet<>();

        Node<T> currentNode = head;
        Node<T> prevNode = null;

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

    public void removeDuplicates2(){
        Node<T> currentNode = head;

        while(currentNode != null){
            Node<T> runnerNode = currentNode.next;
            Node<T> prevNode = currentNode;

            while(runnerNode != null){
                if(currentNode.data.equals(runnerNode.data)){
                    prevNode.next = runnerNode.next;

                    if(runnerNode == tail){
                        prevNode.next = runnerNode.next;
                        tail = prevNode;
                    }
                } else {
                    prevNode = runnerNode;
                }

                runnerNode = runnerNode.next;
            }

            currentNode = currentNode.next;
        }
    }

    public void print() {
        System.out.println("Head ( " + head + " ) " + " ---------> Last ( " + tail + " ):");

        Node<T> currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll1 = new SinglyLinkedList();
        SinglyLinkedList<Integer> sll2 = new SinglyLinkedList();
        // SinglyLinkedList sll3 = new SinglyLinkedList();

        // removeDuplicates1 관련 연결 리스트
        sll1.insertFirst(5);
        sll1.insertFirst(7);
        sll1.insertFirst(5);
        sll1.insertFirst(1);

        // removeDuplicates2 관련 연결 리스트
        sll2.insertFirst(5);
        sll2.insertFirst(4);
        sll2.insertFirst(7);
        sll2.insertFirst(3);
        sll2.insertFirst(5);
        sll2.insertFirst(1);


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
    }
}
