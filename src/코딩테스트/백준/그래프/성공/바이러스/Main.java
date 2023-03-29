package 코딩테스트.백준.그래프.성공.바이러스;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2606
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;


    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            int x = scan.nextInt(), y = scan.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x){
        visited[x] = true;

        for(int y : adj[x]){
            if(visited[y]) continue;

            dfs(y);
            ans++;
        }
    }

    public static void main(String[] args){
        input();
        dfs(1);

        System.out.println(ans);
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