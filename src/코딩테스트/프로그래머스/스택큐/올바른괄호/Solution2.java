package 코딩테스트.프로그래머스.스택큐.올바른괄호;

import java.util.Stack;

class Solution2 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            switch (c){
                case '(' -> stack.push(c);
                case ')' -> {
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("()()");
    }
}