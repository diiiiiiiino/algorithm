package 코딩테스트.백준.그래프.성공.케빈베이컨의6단계법칙;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1389
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ANS = Integer.MAX_VALUE, IDX;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
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

    static int bfs(int start){
        for(int i = 1; i <= N; i++){
            dist[i] = -1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int y : adj[x]){
                if(dist[y] > -1) continue;
                queue.add(y);
                dist[y] = dist[x] + 1;
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += dist[i];
        }

        return sum;
    }

    public static void main(String[] args){
        input();

        for(int i = 1; i <= N; i++){
            dist = new int[N + 1];
            int sum = bfs(i);

            if(ANS > sum){
                ANS = sum;
                IDX = i;
            }
        }

        System.out.println(IDX);
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