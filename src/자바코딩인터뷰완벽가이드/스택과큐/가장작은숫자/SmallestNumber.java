package 자바코딩인터뷰완벽가이드.스택과큐.가장작은숫자;

import java.util.Stack;

public class SmallestNumber {
    public static void smallestAfterRemove(String n, int k){
        if(n == null || k <= 0 || k >= n.length()){
            System.out.println("The number is : " + 0);
            return;
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n.length(); i++){
            while(!stack.isEmpty() && k > 0 && stack.peek() > n.charAt(i)){
                stack.pop();
                k--;
            }

            stack.push(n.charAt(i));
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        System.out.println(stack);
    }

    public static void main(String[] args) {
        smallestAfterRemove("321", 2);
    }
}
