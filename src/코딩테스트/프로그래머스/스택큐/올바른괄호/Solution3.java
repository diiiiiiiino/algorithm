package 코딩테스트.프로그래머스.스택큐.올바른괄호;

import java.util.Stack;

class Solution3 {
    boolean solution(String s) {
        int count = 0;

        for(char c : s.toCharArray()){
            switch (c){
                case '(' -> count++;
                case ')' -> {
                    if(count-- == 0) return false;
                }
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        solution.solution("))()");
    }
}