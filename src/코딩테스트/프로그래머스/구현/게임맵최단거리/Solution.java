package 코딩테스트.프로그래머스.구현.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        boolean[][] isVisited = new boolean[n][m];
        int[][] dist = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = -1;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(0);
        dist[0][0] = 1;
        
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(maps[nx][ny] == 0) continue;
                if(isVisited[nx][ny]) continue;
                
                isVisited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
                
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
        
        return dist[n - 1][m - 1];
    }
}