package 코딩테스트.백준.다시풀기.파티;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1238 다시풀기!!
 */
public class Main {
    static class Edge {
        public int to, weight;

        public Edge(int _to, int _weight){
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info(int _idx, int _dist){
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, X;
    static int[] dist, reverse;
    static ArrayList<Edge>[] edges, reverseEdges;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        X = scan.nextInt();

        dist = new int[N + 1];
        reverse = new int[N + 1];
        edges = new ArrayList[N + 1];
        reverseEdges = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            edges[i] = new ArrayList<>();
            reverseEdges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int weight = scan.nextInt();

            edges[x].add(new Edge(y, weight));
            reverseEdges[y].add(new Edge(x, weight));
        }
    }

    static void dijkstra(int start, ArrayList<Edge>[] edges, int[] dist){
        for(int i = 1; i <= N; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparing(o -> o.dist));

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Info info = pq.poll();

            if(dist[info.idx] != info.dist) continue;

            for(Edge e : edges[info.idx]){
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void pro() {
        // 정답 출력하기
        dijkstra(X, edges, dist);
        dijkstra(X, reverseEdges, reverse);

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            ans = Math.max(ans, dist[i] + reverse[i]);
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
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
