package 자바코딩인터뷰완벽가이드.스택과큐.최솟값스택;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack2 {
    private int min;
    private final Stack<Integer> stack = new Stack<>();

    public void push(int value){
        int r = Math.addExact(value, value);

        if(stack.empty()){
            stack.push(value);
            min = value;
        } else if(value > min){
            stack.push(value);
        } else {
            stack.push(r - min);
            min = value;
        }
    }

    public void pop(){
        if(stack.empty()){
            throw new EmptyStackException();
        }

        int top = stack.peek();

        if(top < min){
            min = 2 * min - top;
        }

        stack.pop();
    }

    public int min(){
        return min;
    }

    public static void main(String[] args) {
        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        stack2.push(2);
        stack2.push(1);

        stack2.pop();
        stack2.pop();
        stack2.pop();
    }
}
