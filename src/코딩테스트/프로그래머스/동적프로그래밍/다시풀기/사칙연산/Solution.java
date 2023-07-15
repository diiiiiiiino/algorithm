package 코딩테스트.프로그래머스.동적프로그래밍.다시풀기.사칙연산;

import java.util.Arrays;

public class Solution {
    private final int[][] maxMem = new int[202][202];

    private int max(int start, int end, String[] arr){
        if(maxMem[start][end] != Integer.MIN_VALUE){
            return maxMem[start][end];
        }

        if(end - start == 1) return Integer.parseInt(arr[start]);

        int max = Integer.MIN_VALUE;
        for(int i = start + 1; i < end; i += 2){
            int l = max(start, i, arr);
            int v;

            if(arr[i].equals("+")){
                int r = max(i + 1, end, arr);
                v = l + r;
            } else {
                int r = min(i + 1, end, arr);
                v = l - r;
            }

            if(v > max) max = v;
        }

        return maxMem[start][end] = max;
    }

    private final int[][] minMem = new int[202][202];

    private int min(int start, int end, String[] arr){
        if(minMem[start][end] != Integer.MIN_VALUE){
            return minMem[start][end];
        }

        if(end - start == 1)
            return Integer.parseInt(arr[start]);

        int min = Integer.MAX_VALUE;
        for(int i = start + 1; i < end; i += 2){
            int l = min(start, i, arr);
            int v;
            if(arr[i].equals("+")){
                int r = min(i + 1, end, arr);
                v = l + r;
            } else {
                int r = max(i + 1, end, arr);
                v = l - r;
            }

            if(v < min)
                min = v;
        }

        return minMem[start][end] = min;
    }

    public int solution(String[] arr){
        for(int[] row : maxMem){
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        for(int[] row : minMem){
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return max(0, arr.length, arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{ "1", "-", "3", "+", "5", "-", "8" });
    }
}
