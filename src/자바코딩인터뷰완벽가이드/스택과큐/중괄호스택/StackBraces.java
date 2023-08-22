package 자바코딩인터뷰완벽가이드.스택과큐.중괄호스택;

import java.util.Stack;

public class StackBraces {
    public static boolean bracesMatching(String bracesStr){
        if(bracesStr == null || bracesStr.isBlank()){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        int len = bracesStr.length();

        for(int i = 0; i < len; i++){
            char ch = bracesStr.charAt(i);
            switch(ch){
                case '{':
                    stack.push(ch);
                    break;
                case '}':
                    if(stack.isEmpty()){
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }

        return stack.empty();
    }
}
