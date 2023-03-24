package 코딩테스트.그래프.다시풀기.다차원토마토;

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
    static int[][][] maps, dist;
    static int[][] dirs = { { 1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, 0, -1 }, { -1, 0, 0 } };

    static void input(){
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();

        maps = new int[H][N][M];
        dist = new int[H][N][M];

        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                    maps[h][n][m] = scan.nextInt();
                    dist[h][n][m] = -1;
                }
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                    if(maps[h][n][m] == 1){
                        queue.add(h);
                        queue.add(n);
                        queue.add(m);
                        dist[h][n][m] = 0;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int h = queue.poll();
            int n = queue.poll();
            int m = queue.poll();

            for(int i = 0; i < 6; i++){
                int nh = dirs[i][0] + h;
                int nn = dirs[i][1] + n;
                int nm = dirs[i][2] + m;

                if(nh < 0 || nm < 0 || nn < 0 || nh >= H || nm >= M || nn >= N) continue;
                if(maps[nh][nn][nm] == -1) continue;
                if(dist[nh][nn][nm] != -1) continue;

                queue.add(nh);
                queue.add(nn);
                queue.add(nm);

                maps[nh][nn][nm] = 1;
                dist[nh][nn][nm] = dist[h][n][m] + 1;
            }
        }
    }

    public static void main(String[] args){
        input();
        bfs();

        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                    if(maps[h][n][m] == -1) continue;
                    if(dist[h][n][m] == -1){
                        System.out.println(-1);
                        return;
                    }

                    ans = Math.max(ans, dist[h][n][m]);
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