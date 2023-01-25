package 코딩테스트.그래프.BOJ7562;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, startX, startY, endX, endY, ans, count;
    static int[][] dir = { {-1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,-2}, {2,-1}, {2,1}, {1,2} };
    static int[][] adj;
    static boolean[][] visit;

    static void input() {
        count = 0;
        ans = Integer.MAX_VALUE;
        N = scan.nextInt();
        adj = new int[N][N];
        startX = scan.nextInt();
        startY = scan.nextInt();
        endX = scan.nextInt();
        endY = scan.nextInt();
    }

    static void dfs(int x, int y){
        count++;

        for(int i = 0; i < 8; i++){
            int nx = x + dir[i][0], ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            dfs(nx, ny);
            visit[nx][ny] = false;
            count--;
        }
    }

    static void pro() {
        dfs(startX, startY);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();

        while(T > 0){
            T--;
            input();
            pro();
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