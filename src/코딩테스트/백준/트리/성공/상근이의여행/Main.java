package 코딩테스트.백준.트리.성공.상근이의여행;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/9372 성공!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();


            for(int y : adj[x]){
                if (visited[y]) continue;

                queue.add(y);
                visited[y] = true;
                ans++;
            }
        }

    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for(int i = 1; i <= T; i++){
            ans = 0;
            visited = new boolean[N + 1];
            input();
            bfs(1);
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