package 자바코딩인터뷰완벽가이드.스택과큐.최단경로;

import java.util.LinkedList;
import java.util.Queue;

public class Sensors {
    private static final int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}, };
    private static final int[][] dirs2 = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1} };

    private static int shortestPath(int[][] board) {
        if(board == null || board.length == 0){
            throw new IllegalArgumentException();
        }

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < dirs2.length; k++){
                    if(board[i][j] == 0){
                        int nx = i + dirs2[k][0];
                        int ny = j + dirs2[k][1];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if(board[nx][ny] == 0) continue;
                        board[nx][ny] = -1;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }

        bfs(n, m, board);

        return 0;
    }

    public static void bfs(int n, int m, int[][] board){
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < board[0].length; i++){
            if(board[i][0] == 0) continue;

            queue.add(i);
            queue.add(0);
            visited[i][0] = true;
            dist[i][0] = 1;
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i < dirs.length; i++){
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny] == 0) continue;

                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int dist = Sensors.shortestPath(board);

        if (dist != -1) {
            System.out.print("\n\nThe shortest safe path has length of " + dist);
        } else {
            System.out.print("\n\nNo route is safe to reach the destination");
        }
    }
}
