package 자바코딩인터뷰완벽가이드.스택과큐.문자열뒤집기;

import java.util.Stack;

public class StackReverseString {
    public static String reverse(String str){
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = reverse("abcd");
        System.out.println(result);
    }
}
