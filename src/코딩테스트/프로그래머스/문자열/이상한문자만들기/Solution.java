package 코딩테스트.프로그래머스.문자열.이상한문자만들기;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.solution("try hello world");
        System.out.println(result);
    }

    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;

        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)){
                builder.append(c);
                toUpper = true;
            } else {
                if(toUpper){
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }

        return builder.toString();
    }
}
