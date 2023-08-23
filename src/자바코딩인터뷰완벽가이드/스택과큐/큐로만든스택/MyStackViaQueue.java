package 자바코딩인터뷰완벽가이드.스택과큐.큐로만든스택;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class MyStackViaQueue<E> {
    private final Queue<E> queue1;
    private final Queue<E> queue2;
    private E peek;
    private int size;

    public MyStackViaQueue() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(E e){
        if(!queue1.isEmpty()){
            if(peek != null){
                queue1.add(peek);
                peek = null;
            }
            queue1.add(e);
        } else {
            if(peek != null){
                queue2.add(peek);
                peek = null;
            }

            queue2.add(e);
        }

        size++;
    }

    public E pop(){
        if(size() == 0){
            throw new EmptyStackException();
        }

        if(peek != null){
            E e = peek;
            peek = null;
            size--;

            return e;
        }

        E e;
        if(!queue1.isEmpty()){
            e = switchQueue(queue1, queue2);
        } else {
            e = switchQueue(queue2, queue1);
        }

        size--;
        return e;
    }

    public E peek(){
        E e;

        if(peek == null){
            if(!queue1.isEmpty()){
                peek = switchQueue(queue1, queue2);
            } else {
                peek = switchQueue(queue2, queue1);
            }
        }

        return peek;
    }

    public int size(){
        return size;
    }

    public void showQueuesStatus() {
        System.out.println("====================");
        System.out.println("queue1 Status");
        System.out.println(queue1);
        System.out.println("Size: " + queue1.size());
        System.out.println("queue2 Status");
        System.out.println(queue2);
        System.out.println("Size: " + queue2.size());
        System.out.println("--------------------");
        System.out.println("");
    }

    private E switchQueue(Queue<E> from, Queue<E> to){
        while(from.size() > 1){
            to.add(from.poll());
        }

        return from.poll();
    }
}
