package 자바코딩인터뷰완벽가이드.스택과큐.섬;

import java.util.LinkedList;
import java.util.Queue;

public class QueueIslands {
    private static final int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1} };

    private static int islands(int[][] matrix) {
        int result = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j]) continue;
                if(matrix[i][j] == 0) continue;

                bfs(i, j, matrix, visited, n, m);
                result++;
            }
        }

        return result;
    }

    public static void bfs(int startX, int startY, int[][] matrix, boolean[][] visited, int n, int m){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startX);
        queue.add(startY);
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i < dir.length; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(matrix[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 0, 0, 0, 1, 1, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
                {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 1, 1, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1, 0, 1, 1, 1}
        };

        int islandsNo = QueueIslands.islands(matrix);
        System.out.println("Number of islands: " + islandsNo);
    }
}
