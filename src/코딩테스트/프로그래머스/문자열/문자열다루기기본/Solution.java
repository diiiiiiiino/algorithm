package 코딩테스트.프로그래머스.문자열.문자열다루기기본;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.solution("a234");
        System.out.println(result);
    }

    public boolean solution(String s){
        return s.matches("[0-9]{4}|[0-9]{6}");
    }

    public boolean solution2(String s){
        if(s.length() != 4 && s.length() != 6) return false;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c))
                return false;
        }

        return true;
    }
}
