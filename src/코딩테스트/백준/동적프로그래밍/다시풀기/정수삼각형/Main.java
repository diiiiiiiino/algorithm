package 코딩테스트.백준.동적프로그래밍.다시풀기.정수삼각형;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1932 다시풀기!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] dy;

    static void input() {
        N = scan.nextInt();
        dy = new int[N + 5][N + 5];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dy[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dy[i][j] += Math.max(dy[i-1][j-1], dy[i-1][j]);
            }
        }

        Arrays.sort(dy[N], 1, N + 1);
        System.out.println(dy[N][N]);
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