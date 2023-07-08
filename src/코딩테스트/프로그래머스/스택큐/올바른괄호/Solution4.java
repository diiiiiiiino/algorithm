package 코딩테스트.프로그래머스.스택큐.올바른괄호;

import java.util.Stack;

class Solution4 {
    private void findPair(char[] str){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < str.length; i++){
            switch(str[i]){
                case '(' -> stack.push(i);
                case ')' -> {
                    if(stack.isEmpty()) return;

                    System.out.println(stack.pop() + ", " + i );
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        solution.findPair(new char[]{'(', '(', ')', ')'});
    }
}