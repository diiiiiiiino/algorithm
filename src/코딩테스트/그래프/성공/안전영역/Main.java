package 코딩테스트.그래프.성공.안전영역;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2468 성공!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans = 1;
    static int[][] dir = { {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] adj;
    static boolean[][] visited, downed;
    static int[] heights;

    static void input() {
        N = scan.nextInt();
        adj = new int[N][N];
        visited = new boolean[N][N];
        downed = new boolean[N][N];
        heights = new int[100 + 1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                adj[i][j] = scan.nextInt();
                heights[adj[i][j]] = 1;
            }
        }
    }

    static void dfs(int x, int y, int height) {
        visited[x][y] = true;
        for(int k = 0; k < 4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if(downed[nx][ny]) continue;

            if(adj[nx][ny] <= height){
                downed[nx][ny] = true;
                visited[nx][ny] = true;
                continue;
            }


            dfs(nx, ny, height);
        }
    }


    public static void main(String[] args) {
        input();

        for(int height = 1; height <= 100; height++){
            if(heights[height] == 0) continue;
            init();
            int count = 0;
            for(int x = 0; x < N; x++){
                for(int y = 0; y < N; y++){
                    if(visited[x][y]) continue;
                    if(downed[x][y]) continue;
                    if(adj[x][y] <= height){
                        downed[x][y] = true;
                        continue;
                    }
                    dfs(x, y, height);
                    count++;
                }
            }
            ans = Math.max(count, ans);
        }

        System.out.println(ans);
    }

    static void init(){
        for(int n = 0; n < N; n++){
            for(int m = 0; m < N; m++){
                visited[n][m] = false;
                downed[n][m] = false;
            }
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}