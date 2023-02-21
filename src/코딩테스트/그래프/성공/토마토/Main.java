package 코딩테스트.그래프.성공.토마토;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7576 성공!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static int[][] dir = { {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] adj, dist;
    static boolean[][] visited;
    static Queue<Integer> queue = new LinkedList<>();

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        adj = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                adj[i][j] = scan.nextInt();
                if(adj[i][j] == 1){
                    queue.add(i);
                    queue.add(j);
                }
            }
        }
    }

    static void bfs() {
        while(!queue.isEmpty()){
            int ax = queue.poll();
            int ay = queue.poll();
            visited[ax][ay] = true;

            for(int i = 0; i < 4; i++){
                int nx = dir[i][0] + ax;
                int ny = dir[i][1] + ay;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(adj[nx][ny] == -1 || adj[nx][ny] == 1) continue;

                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
                adj[nx][ny] = 1;
                dist[nx][ny] = dist[ax][ay] + 1;

                ans = Math.max(dist[nx][ny], ans);
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(adj[i][j] == 0){
                    ans = -1;
                    break;
                }
            }
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