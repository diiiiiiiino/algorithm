package 코딩테스트.프로그래머스.문자열.자연수뒤집어배열로만들기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] results = solution.solution2(12345);

        System.out.println(Arrays.toString(results));
    }

    public int[] solution(long n) {
        String num = String.valueOf(n);
        String[] strings = num.split("");
        int[] answer = new int[strings.length];

        for(int i = strings.length - 1, j = 0; i >= 0; i--, j++){
            answer[j] = Integer.valueOf(strings[i]);
        }

        return answer;
    }

    public int[] solution2(long n) {
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
