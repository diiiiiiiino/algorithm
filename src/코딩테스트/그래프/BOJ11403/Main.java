package 코딩테스트.그래프.BOJ11403;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] adj, ans;
    static boolean[] visited;

    static void input() {
        N = scan.nextInt();
        visited = new boolean[N + 1];
        adj = new int[N + 1][N + 1];
        ans = new int[N + 1][N + 1];

        for(int x = 1; x <= N; x++){
            for(int y = 1; y <= N; y++){
                adj[x][y] = scan.nextInt();
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int y : adj[x]){
                if(visited[y]) continue;

                queue.add(y);
                visited[y] = true;
            }
        }
    }

    static void pro() {
        bfs(1);
    }

    public static void main(String[] args) {
        input();
        pro();

        StringBuilder sb = new StringBuilder();
        for(int x = 1; x <= N; x++){
            for(int y = 1; y <= N; y++){

            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
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