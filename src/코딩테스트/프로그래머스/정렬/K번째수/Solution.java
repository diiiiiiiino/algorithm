package 코딩테스트.프로그래머스.정렬.K번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int[] cmd = commands[i];
            int start = cmd[0], end = cmd[1], idx = cmd[2];
            
            int[] subNums = Arrays.copyOfRange(array, start - 1, end);
            
            Arrays.sort(subNums);
            
            int result = subNums[idx - 1];
            
            answer[i] = result;
        }
        
        return answer;
    }
}