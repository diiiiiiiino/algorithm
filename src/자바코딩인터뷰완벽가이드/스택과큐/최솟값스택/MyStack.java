package 자바코딩인터뷰완벽가이드.스택과큐.최솟값스택;

import java.util.Stack;

public class MyStack extends Stack<Integer> {
    Stack<Integer> stackOfMin;

    public MyStack(){
        stackOfMin = new Stack<>();
    }

    public Integer push(int value){
        if(value <= min()){
            stackOfMin.push(value);
        }

        return super.push(value);
    }

    @Override
    public Integer pop() {
        int value = super.pop();

        if(value == min()){
            stackOfMin.pop();
        }

        return value;
    }

    public int min(){
        if(stackOfMin.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return stackOfMin.peek();
        }
    }
}
