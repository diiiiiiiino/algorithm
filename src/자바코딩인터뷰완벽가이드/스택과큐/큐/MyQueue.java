package 자바코딩인터뷰완벽가이드.스택과큐.큐;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class MyQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int count;
    private int front;
    private int rear;
    private int capacity;
    private E[] queue;

    public MyQueue(){
        queue = (E[]) Array.newInstance(Object[].class.getComponentType(), DEFAULT_CAPACITY);
        count = 0;
        front = 0;
        rear = -1;
        capacity = DEFAULT_CAPACITY;
    }

    public void enqueue(E e){
        if(isFull()){
            ensureCapacity();
        }

        rear = (rear + 1) % capacity;

        queue[rear] = e;
        count++;
    }

    public E dequeue(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        E e = queue[front];
        queue[front] = null;

        front = (front + 1) % capacity;

        count--;

        return e;
    }

    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return queue[front];
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean isFull(){
        return size() == capacity;
    }

    private void ensureCapacity() {
        int newSize = capacity * 2;
        queue = Arrays.copyOf(queue, newSize);
        capacity = newSize;
    }

    public static void main(String[] args) {
        MyQueue<Integer> stack = new MyQueue();

        stack.enqueue(25);
        stack.enqueue(35);
        stack.enqueue(15);

        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 17");
        stack.enqueue(17);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 55");
        stack.enqueue(55);
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Is empty? " + stack.isEmpty());
    }
}
