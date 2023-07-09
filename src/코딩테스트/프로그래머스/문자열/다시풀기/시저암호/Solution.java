package 코딩테스트.프로그래머스.문자열.다시풀기.시저암호;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("z", 1);

        System.out.println(result);
    }

    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()){
            builder.append(push(c, n));
        }

        return builder.toString();
    }

    private char push(char c, int n){
        if(!Character.isAlphabetic(c)) return c;

        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);

        return (char) (offset + position);
    }
}
