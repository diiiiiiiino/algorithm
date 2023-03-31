package 코딩테스트.백준.그래프.다시풀기.경로찾기;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11403
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] adj;
    static boolean[] visited;
    static void input(){
        N = scan.nextInt();
        adj = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                adj[i][j] = scan.nextInt();
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) visited[i] = false;

        queue.add(start);

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int y = 1; y <= N; y++){
                if(adj[x][y] == 0) continue;
                if(visited[y]) continue;

                queue.add(y);
                visited[y] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i] ? 1 : 0).append(' ');
        }
        sb.append('\n');
    }

    public static void main(String[] args){
        input();

        for(int i = 1; i <= N; i++){
            bfs(i);
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