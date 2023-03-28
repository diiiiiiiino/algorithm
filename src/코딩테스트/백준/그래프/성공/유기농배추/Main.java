package 코딩테스트.백준.그래프.성공.유기농배추;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1012
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M, N, K;
    static int[][] map;
    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static boolean[][] visited;


    static void input(){
        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < K; i++){
            int y = scan.nextInt();
            int x = scan.nextInt();

            map[x][y] = 1;
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = dir[i][0] + x;
            int ny = dir[i][1] + y;

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args){
        int T = scan.nextInt();

        for(int i = 0; i < T; i++){
            input();
            int ans = 0;

            for(int x = 0; x < N; x++){
                for(int y = 0; y < M; y++){
                    if(visited[x][y]) continue;
                    if(map[x][y] == 0) continue;
                    dfs(x, y);
                    ans++;
                }
            }

            System.out.println(ans);
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