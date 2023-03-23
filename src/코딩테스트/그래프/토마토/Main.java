package 코딩테스트.그래프.토마토;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7569 다시풀기!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M, N, H, ans;
    static int[][] nums;
    static int[][][] maps, dist;
    static boolean[][][] visited;
    static int[][] dir = { { 0, -1, 0 } , { 0, 0, 1 }, { 0, 1, 0 }, { 0, 0, -1 }, { -1, 0, 0 }, { 1, 0, 0 } };
    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();

        nums = new int[N][M];
        maps = new int[H][N][M];
        visited = new boolean[H][N][M];
        dist = new int[H][N][M];

        for(int z = 0; z < H; z++){
            for(int x = 0; x < N; x++){
                for(int y = 0; y < M; y++){
                    maps[z][x][y] = scan.nextInt();
                }
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        for(int z = 0; z < H; z++){
            for(int x = 0; x < N; x++){
                for(int y = 0; y < M; y++){
                    dist[z][x][y] = -1;
                    if(maps[z][x][y] == 1){
                        dist[z][x][y] = 0;
                        queue.add(z);
                        queue.add(x);
                        queue.add(y);
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int z = queue.poll();
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i < 6; i++){
                int nz = dir[i][0] + z;
                int nx = dir[i][1] + x;
                int ny = dir[i][2] + y;

                if(nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) continue;
                if(maps[nz][nx][ny] == -1) continue;
                if(dist[nz][nx][ny] != -1) continue;

                queue.add(nz);
                queue.add(nx);
                queue.add(ny);

                dist[nz][nx][ny] = dist[z][x][y] + 1;
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs();

        int ans = 0;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (maps[h][i][j] == -1) continue;
                    if (dist[h][i][j] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, dist[h][i][j]);
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