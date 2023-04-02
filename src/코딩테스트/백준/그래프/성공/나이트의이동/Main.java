package 코딩테스트.백준.그래프.성공.나이트의이동;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7562
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int L, startX, startY, endX, endY;
    static int[][] dist;
    static int[][] dirs = { {-2,-1}, { -2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}};

    static void input(){
        L = scan.nextInt();
        dist = new int[L][L];


        startX = scan.nextInt();
        startY = scan.nextInt();
        endX = scan.nextInt();
        endY = scan.nextInt();
    }

    static void bfs(){
        for(int i = 0; i < L; i++){
            for(int j = 0; j < L; j++){
                dist[i][j] = -1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        dist[startX][startY] = 0;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i < 8; i++){
                int nx = dirs[i][0] + x;
                int ny = dirs[i][1] + y;

                if(nx < 0 || ny < 0 || nx >= L || ny >= L) continue;
                if(dist[nx][ny] != -1) continue;

                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    public static void main(String[] args){
        int T = scan.nextInt();
        for(int i = 1; i <= T; i++){
            input();
            bfs();
            System.out.println(dist[endX][endY]);
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