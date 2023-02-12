package 코딩테스트.트리.트리의지름;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1967 다시풀기!!
 */
public class Main {
    static class Edge{
        int vertex;
        int weight;

        Edge(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans = Integer.MIN_VALUE;
    static ArrayList<Edge>[] adj;
    static boolean[] visited;

    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList();
        }

        for(int i = 1; i < N; i++){
            int parent = scan.nextInt();
            int vertex = scan.nextInt();
            int weight = scan.nextInt();

            adj[parent].add(new Edge(vertex, weight));
            adj[vertex].add(new Edge(parent, weight));
        }
    }

    static void dfs(int x, int sum){
        visited[x] = true;

        for(Edge edge : adj[x]){
            if(visited[edge.vertex]) continue;
            dfs(edge.vertex, sum + edge.weight);
        }

        ans = Math.max(sum, ans);
    }

    static void pro() {
        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            dfs(i, 0);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
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