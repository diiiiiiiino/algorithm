package 코딩테스트.백준.다시풀기.특정한최단경로;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1504 다시풀기!!
 */
public class Main {
    static class Edge{
        public int to;
        public int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info{
        public int idx;
        public int dist;

        public Info(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N, E, V1, V2, inf = 200000000, ans = inf;
    static ArrayList<Edge>[] edges;
    static int[] dist;

    static void input() {
        N = scan.nextInt();
        E = scan.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        V1 = scan.nextInt();
        V2 = scan.nextInt();
    }

    static void pro(int start) {
        for(int i = 1; i <= N; i++){
            dist[i] = inf;
        }

        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparing(o -> o.dist));
        queue.add(new Info(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Info info = queue.poll();

            if(dist[info.idx] != info.dist) continue;

            for(Edge edge : edges[info.idx]){
                if(dist[info.idx] + edge.weight >= dist[edge.to]) continue;

                dist[edge.to] = dist[info.idx] + edge.weight;
                queue.add(new Info(edge.to, dist[edge.to]));
            }
        }
    }


    public static void main(String[] args) {
        input();
        pro(1);
        int startToV1 = dist[V1];
        int startToV2 = dist[V2];

        pro(V1);
        int V1toV2 = dist[V2];
        int V1toN = dist[N];

        pro(V2);
        int V2toN = dist[N];


        ans = Math.min(ans, startToV1 + V1toV2 + V2toN);
        ans = Math.min(ans, startToV2 + V1toV2 + V1toN);

        if(ans >= inf){
            ans = -1;
        }

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
