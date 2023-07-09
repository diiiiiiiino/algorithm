package 코딩테스트.프로그래머스.이진탐색.다시풀기.입국심사;

public class Solution {
    private boolean isValid(long t, int n, int[] times){
        long c = 0;
        for(int time : times){
            c += t / time;
        }

        return c >= n;
    }

    public long solution(int n, int[] times){
        long start = 1;
        long end = 1000000000000000000L;

        while(end > start){
            long t = (start + end) / 2;

            if(isValid(t, n, times)){
                end = t;
            } else {
                start = t + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long result = s.solution(6, new int[]{7, 10});
        System.out.println(result);
    }
}
