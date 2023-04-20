package 코딩테스트.백준.트리.다시풀기.success.노드사이의거리;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1240
 */
public class Main {
    static class Edge{
        int vertex;
        int dist;

        Edge(int vertex, int dist){
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static ArrayList<Edge>[] adj;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int dist = scan.nextInt();

            adj[x].add(new Edge(y, dist));
            adj[y].add(new Edge(x, dist));
        }
    }

    static void dfs(int x, int prev, int goal, int dist){
        if(x == goal){
            ans = dist;
            return;
        }

        for(Edge edge : adj[x]){
            if(edge.vertex == prev) continue;

            dfs(edge.vertex, x, goal, edge.dist + dist);
        }
    }

    static void pro(){
        for(int i = 1; i <= M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            dfs(x, -1, y, 0);
            System.out.println(ans);
        }
    }

    public static void main(String[] args){
        input();
        pro();
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
