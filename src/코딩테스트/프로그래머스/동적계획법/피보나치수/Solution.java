package 코딩테스트.프로그래머스.동적계획법.피보나치수;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] dy = new int[n + 1];
        
        dy[0] = 0;
        dy[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dy[i] = (dy[i - 1] + dy[i - 2]) % 1234567;
        }
        
        return dy[n];
    }
}