package 자바코딩인터뷰완벽가이드.스택과큐.접시스택;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class StackOfPlates {
    private static final int STACK_SIZE = 3;

    private final LinkedList<Stack<Integer>> stacks = new LinkedList<>();

    public void push(int value){
        if(stacks.isEmpty() || stacks.getLast().size() >= STACK_SIZE){
            Stack<Integer> stack = new Stack<>();
            stack.push(value);

            stacks.add(stack);
        } else {
            stacks.getLast().push(value);
        }
    }

    public Integer pop(){
        if(stacks.isEmpty()){
            throw new EmptyStackException();
        }

        Stack<Integer> stack = stacks.getLast();
        int value = stack.pop();

        removeStackIfEmpty();

        return value;
    }

    public Integer popAt(int stackIndex){
        if(stacks.isEmpty()){
            throw new EmptyStackException();
        }

        if(stackIndex < 0 || stackIndex >= stacks.size()){
            throw new IllegalArgumentException("The given is out of bounds");
        }

        Stack<Integer> stack = stacks.get(stackIndex);
        int value = stack.pop();

        shift(stackIndex);

        removeStackIfEmpty();

        return value;
    }

    private void shift(int stackIndex) {
        for(int i = stackIndex; i < stackIndex - 1; i++){
            Stack<Integer> currentStack = stacks.get(i);
            Stack<Integer> nextStack = stacks.get(i + 1);

            currentStack.push(nextStack.remove(0));
        }
    }

    private void removeStackIfEmpty() {
        if(stacks.getLast().isEmpty()){
            stacks.removeLast();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        //stack.remove(0);
        stack.pop();

        System.out.println(stack);
    }
}
