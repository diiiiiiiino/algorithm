package 코딩테스트.프로그래머스.동적계획법.등굣길;

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dy = new int[n][m];
        
        dy[0][0] = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(checkPuddle(i, j, puddles)) continue;
                
                if(i > 0 && j > 0){
                    dy[i][j] = (dy[i - 1][j] + dy[i][j - 1]) % 1_000_000_007;
                } else if(i == 0 && j > 0) {
                    dy[i][j] = (dy[i][j - 1]) % 1_000_000_007;
                } else if(i > 0 && j == 0){
                    dy[i][j] = (dy[i - 1][j]) % 1_000_000_007;
                }
            }
        }
        
        for(int[] a : dy){
            System.out.println(Arrays.toString(a));
        }
        
        return dy[n - 1][m - 1];
    }
    
    private boolean checkPuddle(int i, int j, int[][] puddles){
        for(int k = 0; k < puddles.length; k++){
            int y = puddles[k][0] - 1, x = puddles[k][1] - 1;
            
            if(x == i && y == j){
                return true;
            }
        }
        
        return false;
    }
}