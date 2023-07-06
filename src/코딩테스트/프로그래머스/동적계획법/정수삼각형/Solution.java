package 코딩테스트.프로그래머스.동적계획법.정수삼각형;

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int idx = triangle.length - 1;
        
        for(int i = idx - 1; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                int left = j, right = j + 1;
                triangle[i][j] = Math.max(triangle[i + 1][left], triangle[i + 1][right]) + triangle[i][j];
            }
        }
        
        return triangle[0][0];
    }
}