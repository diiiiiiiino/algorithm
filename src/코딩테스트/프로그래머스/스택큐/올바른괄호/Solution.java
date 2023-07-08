package 코딩테스트.프로그래머스.스택큐.올바른괄호;

import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for(char ch : chars){
            stack.push(ch);
        }

        int openCnt = 0;
        int closeCnt = 0;
        while(!stack.isEmpty()){
            char ch = stack.pop();

            if(closeCnt == 0 && ch == '('){
                return false;
            }

            if(ch == '('){
                openCnt++;
                
                if(openCnt > closeCnt){
                    return false;
                }
            } else {
                closeCnt++;
            }
        }

        return openCnt == closeCnt;
    }
}