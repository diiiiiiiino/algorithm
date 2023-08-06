package 코딩테스트.프로그래머스.구현.네트워크;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(computers[i][j] == 1 && i != j){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        
        for(int x = 0; x < n; x++){
            if(visited[x]) continue;
            answer++;
            dfs(adj, visited, x);
        }
        
        return answer;
    }
    
    private void dfs(List<Integer>[] adj, boolean[] visited, int x){
        visited[x] = true;
        
        for(int y : adj[x]){
            if(visited[y]) continue;
            
            dfs(adj, visited, y);
        }
    }
}