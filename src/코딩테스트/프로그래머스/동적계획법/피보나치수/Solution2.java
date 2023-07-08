package 코딩테스트.프로그래머스.동적계획법.피보나치수;

import java.util.Arrays;

class Solution2 {
    private final int[] mem = new int[10001];
    private int fibonacci(int n){
        if(mem[n] != -1) return mem[n];
        if(n == 0 || n == 1) return n;

        return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) & 1234567;
    }

    public int solution(int n) {
        Arrays.fill(mem, -1);
        for(int i = 0; i <= n; i++){
            fibonacci(n);
        }

        return fibonacci(n);
    }
}