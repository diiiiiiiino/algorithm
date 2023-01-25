package 코딩테스트.그래프.BOJ1260_matrix;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        adj = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        /* TODO */
        for(int i = 0; i < M; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x][y] = adj[y][x] = 1;
        }
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) {
        /* TODO */
        visit[x] = true;
        sb.append(x).append(" ");

        for(int y = 1; y <= N; y++){
            if(adj[x][y] == 0) continue;
            if(visit[y]) continue;

            dfs(y);
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        /* TODO */
        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()){
            int x = que.poll();
            sb.append(x).append(" ");

            for(int n = 1; n <= N; n++){
                if(adj[x][n] == 0) continue;
                if(visit[n]) continue;

                que.add(n);
                visit[n] = true;
            }
        }
    }

    static void pro() {
        // DFS, BFS 결과 구하기
        /* TODO */
        dfs(V);
        visit = new boolean[N + 1];
        sb.append("\n");
        bfs(V);

        System.out.println(sb);
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