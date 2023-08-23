package 자바코딩인터뷰완벽가이드.스택과큐.스택으로만든큐;

import java.util.Stack;

public class MyQueueViaStack<E> {
    private final Stack<E> stackEnqueue;
    private final Stack<E> stackDequeue;

    public MyQueueViaStack(){
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    public void enqueue(E e){
        stackEnqueue.push(e);
    }

    public E dequeue(){
        reverseStackEnqueue();

        return stackDequeue.pop();
    }

    public E peek(){
        reverseStackEnqueue();
        return stackDequeue.peek();
    }

    public int size(){
        return stackEnqueue.size() + stackDequeue.size();
    }

    private void reverseStackEnqueue(){
        if(stackDequeue.isEmpty()){
            while(!stackEnqueue.isEmpty()){
                stackDequeue.push(stackEnqueue.pop());
            }
        }
    }
}
