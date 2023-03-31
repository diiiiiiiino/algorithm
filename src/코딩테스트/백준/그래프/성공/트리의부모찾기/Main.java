package 코딩테스트.백준.그래프.성공.트리의부모찾기;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11725
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] ans;

    static void input(){
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x, int p){
        visited[x] = true;
        ans[x] = p;

        for(int y : adj[x]){
            if(visited[y]) continue;
            dfs(y, x);
        }
    }

    static void dfs2(int x, int par) {
        for (int y : adj[x]) {
            if (y == par)
                continue;
            ans[y] = x;
            dfs2(y, x);
        }
    }

    public static void main(String[] args){
        input();
        dfs(1, 1);

        for(int i = 2; i <= N; i++){
            System.out.println(ans[i]);
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