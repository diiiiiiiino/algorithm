package 코딩테스트.최단거리.BOJ1753;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info{
        int idx;
        int dist;

        public Info(int from, int dist){
            this.idx = from;
            this.dist = dist;
        }
    }

    static int V, E, K;
    static ArrayList<Edge>[] edges;
    static int[] dist;

    static void input() {
        V = scan.nextInt();
        E = scan.nextInt();
        K = scan.nextInt();
        dist = new int[V + 1];
        edges = new ArrayList[V + 1];

        for(int i = 1; i <= V; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++){
            int u = scan.nextInt(), v = scan.nextInt(), w = scan.nextInt();
            edges[u].add(new Edge(v, w));
        }
    }

    static void dijkstra(int start) {
        for(int i = 1; i <= V; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> priorityQueue = new PriorityQueue<>(Comparator.comparing(o -> o.dist));
        priorityQueue.add(new Info(start, 0));
        dist[start] = 0;

        while(!priorityQueue.isEmpty()){
            Info info = priorityQueue.poll();

            if(info.dist > dist[info.idx]) continue;

            for(Edge edge : edges[info.idx]){
                if(info.dist + edge.weight > dist[edge.to]) continue;

                priorityQueue.add(new Info(edge.to, info.dist + edge.weight));
                dist[edge.to] = info.dist + edge.weight;
            }
        }
    }

    public static void main(String[] args) {
        input();
        dijkstra(K);

        for(int i = 1; i <= V; i++){
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
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