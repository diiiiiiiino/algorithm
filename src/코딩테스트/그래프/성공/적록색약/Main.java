package 코딩테스트.그래프.성공.적록색약;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10026
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static int[][] dir = { {-1, 0}, {0, -1}, {0, 1}, {1, 0} };
    static boolean[][] visited;
    static String[][] map;

    static void input() {
        N = scan.nextInt();
        visited = new boolean[N][N];
        map = new String[N][N];

        for(int i = 0; i < N; i++){
            map[i] = scan.nextLine().split("");
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = dir[i][0] + x;
            int ny = dir[i][1] + y;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if(!map[x][y].equals(map[nx][ny])) continue;

            dfs(nx, ny);
        }
    }

    static void dfs2(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = dir[i][0] + x;
            int ny = dir[i][1] + y;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if(((map[x][y].equals("R") || map[x][y].equals("G")) && map[nx][ny].equals("B")) ||
                ((map[nx][ny].equals("R") || map[nx][ny].equals("G")) && map[x][y].equals("B"))) continue;

            dfs2(nx, ny);
        }
    }

    public static void main(String[] args) {
        input();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                dfs(i, j);
                ans++;
            }
        }
        sb.append(ans).append(" ");

        ans = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                dfs2(i, j);
                ans++;
            }
        }
        sb.append(ans);

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