package 자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static public void main(String[] args) {
        System.out.println("================= Queue Start ================");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(2);
        queue.add(1);

        while(queue.iterator().hasNext()) {
            System.out.println("item : " + queue.poll());
        }

        queue.stream().forEach(v -> System.out.println(v));
        System.out.println("size : " + queue.size());

        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(3);
        myQueue.add(2);
        myQueue.add(1);

        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

        System.out.println("================= Queue End ================");

        System.out.println("================= Stack Start ================");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(stack.iterator().hasNext()){
            System.out.println("itme : " + stack.pop());
        }

        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

        System.out.println("================= Stack End ================");

        System.out.println("================= SingleLinkedList Start ================");
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNodeInside(7, 2);


        list.printAll();

        System.out.println("================= SingleLinkedList End ================");

        System.out.println("================= DoubleLinkedList Start ================");
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);


        System.out.println(linkedList.insertToFront(1, 4));
        linkedList.printAll();

        System.out.println("================= DoubleLinkedList End ================");

        System.out.println("================= Hash Start ================");
        MyHash mainObject = new MyHash(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");

        System.out.println(mainObject.getData("Dave"));

        MyHash2 mainObject2 = new MyHash2(20);
        mainObject2.saveData("DaveLee", "01022223333");
        mainObject2.saveData("fun-coding", "01033334444");
        mainObject2.saveData("David", "01044445555");
        mainObject2.saveData("Dave", "01055556666");

        System.out.println(mainObject2.getData("DaveLee"));
        System.out.println(mainObject2.getData("Dave"));
        System.out.println("================= Hash End ================");


        MyHeap heapTest = new MyHeap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArr);

        heapTest.pop();
        System.out.println(heapTest.heapArr);

        Heap heapTest2 = new Heap(15);
        heapTest2.insert(10);
        heapTest2.insert(8);
        heapTest2.insert(5);
        heapTest2.insert(4);
        heapTest2.insert(20);
        System.out.println(heapTest2.heapArray);

        heapTest2.pop();
        System.out.println(heapTest2.heapArray);
    }
}
