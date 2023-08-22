package 자바코딩인터뷰완벽가이드.스택과큐.스택;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.StringJoiner;

public class MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int top;

    public MyStack(){
        array = (E[]) Array.newInstance(Object[].class.getComponentType(), DEFAULT_CAPACITY);
        top = 0;
    }

    public void push(E e){
        if(isFull()){
            ensureCapacity();
        }
        array[top++] = e;
    }

    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        E value = array[--top];
        array[top] = null;

        return value;
    }

    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return array[top - 1];
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public boolean isFull(){
        return top == array.length;
    }

    private void ensureCapacity(){
        array = Arrays.copyOf(array, array.length * 2);
    }

    public void print(){
        StringJoiner sj = new StringJoiner(", ");
        for(int i = 0; i < top; i++){
            sj.add(String.valueOf(array[i]));
        }

        System.out.println(sj);
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        myStack.push(9);
        myStack.push(10);

        myStack.print();

        myStack.push(11);

        myStack.print();

        System.out.println("myStack.size() : " + myStack.size());

        myStack.pop();

        myStack.print();

        System.out.println("myStack.peek() : " + myStack.peek());
    }
}
