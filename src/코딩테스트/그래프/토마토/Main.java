package 코딩테스트.그래프.토마토;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M, N, H, ans;
    static int[][] nums;
    static int[][][] maps;
    static boolean[][][] visited;
    static int[][] dir = { { 0, -1, 0 } , { 0, 0, 1 }, { 0, 1, 0 }, { 0, 0, -1 }, { -1, 0, 0 }, { 1, 0, 0 } };
    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();

        nums = new int[N][M];
        maps = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                nums[i][j] = scan.nextInt();
            }
        }

        for(int i = 0; i < H; i++){
            maps[i] = nums;
        }
        
    }

    public static void main(String[] args) {
        input();

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