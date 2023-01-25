package 코딩테스트.위상정렬.BOJ9470;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, K, M, P;
    static int[] degree, orders;
    static ArrayList<Integer>[] adj;


    static void input() {
        K = scan.nextInt();
        M = scan.nextInt();
        P = scan.nextInt();

        degree = new int[M + 1];
        orders = new int[M + 1];
        adj = new ArrayList[M + 1];
        for(int i = 1; i <= M; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= P; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            degree[y]++;
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= M; i++){
            if(degree[i] == 0){
                orders[i] = 1;
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int y : adj[x]){
                orders[y] = Math.max(orders[x], orders[y]);

                degree[y]--;
                if(degree[y] == 0){
                    queue.add(y);

                    if(orders[x] == orders[y]){
                        orders[y] = orders[y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        T = scan.nextInt();

        for(int i = 0; i < T; i++){
            input();
            pro();
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
