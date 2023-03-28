package 코딩테스트.백준.그래프.성공.섬의개수;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4963
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int h, w;
    static int[][] map;
    static int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1} };
    static boolean[][] visited;

    static void input(){
        map = new int[h][w];
        visited = new boolean[h][w];

        for(int x = 0; x < h; x++){
            for(int y = 0; y < w; y++){
                map[x][y] = scan.nextInt();
            }
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 8; i++){
            int nx = dir[i][0] + x;
            int ny = dir[i][1] + y;

            if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args){
        while(true){
            w = scan.nextInt();
            h = scan.nextInt();
            if(w == 0 && h == 0) break;

            input();
            int ans = 0;
            for(int x = 0; x < h; x++){
                for(int y = 0; y < w; y++){
                    if(visited[x][y]) continue;
                    if(map[x][y] == 0) continue;
                    dfs(x, y);
                    ans++;
                }
            }
            System.out.println(ans);
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