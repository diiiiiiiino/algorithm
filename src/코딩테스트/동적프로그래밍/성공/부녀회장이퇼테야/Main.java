package 코딩테스트.동적프로그래밍.성공.부녀회장이퇼테야;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2775
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[][] dy;
    static void input() {
        K = scan.nextInt();
        N = scan.nextInt();
        dy = new int[K + 1][N + 1];
    }

    static void pro() {
        for(int i = 1; i <= N; i++){
            dy[0][i] = i;
        }

        for(int i = 1; i <= K; i++){
            for(int j = 1; j <= N; j++){
                for(int k = 1; k <= j; k++){
                    dy[i][j] += dy[i - 1][k];
                }
            }
        }

        System.out.println(dy[K][N]);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for(int i = 1; i <= T; i++){
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