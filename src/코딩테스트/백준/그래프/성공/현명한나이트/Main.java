package 코딩테스트.백준.그래프.성공.현명한나이트;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18404
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, X, Y;
    static int[][] check;
    static int[][] dir = { {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1} };
    static int[][] dist;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        X = scan.nextInt();
        Y = scan.nextInt();

        check = new int[M + 1][2];
        for(int i = 1; i <= M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            check[i][0] = x;
            check[i][1] = y;
        }

        dist = new int[N + 1][N + 1];
    }

    static void bfs(int startX, int startY){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                dist[i][j] = -1;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startX);
        queue.add(startY);
        dist[startX][startY] = 0;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i < 8; i++){
                int nx = dir[i][0] + x;
                int ny = dir[i][1] + y;

                if(nx < 0 || ny < 0 || nx > N || ny > N) continue;
                if(dist[nx][ny] > -1) continue;

                queue.add(nx);
                queue.add(ny);

                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    public static void main(String[] args){
        input();
        bfs(X, Y);

        for(int i = 1; i <= M; i++){
            int x = check[i][0];
            int y = check[i][1];

            sb.append(dist[x][y]).append(" ");
        }
        System.out.println(sb.toString());
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