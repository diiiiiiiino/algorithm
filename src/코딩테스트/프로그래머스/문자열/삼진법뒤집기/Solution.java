package 코딩테스트.프로그래머스.문자열.삼진법뒤집기;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(45);
    }

    public int solution(int n){
        String triNum = Integer.toString(n, 3);
        String reverseNum = new StringBuilder(triNum).reverse().toString();

        int result = Integer.parseInt(reverseNum, 3);

        return Integer.valueOf(reverseNum, 3);
    }
}
