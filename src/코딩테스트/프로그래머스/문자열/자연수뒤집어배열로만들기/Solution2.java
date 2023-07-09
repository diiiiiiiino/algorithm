package 코딩테스트.프로그래머스.문자열.자연수뒤집어배열로만들기;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] results = solution.solution(12345);

        System.out.println(Arrays.toString(results));
    }

    public int[] solution(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();

        int[] result = new int[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = arr[i] - '0';
        }

        return result;
    }
}
