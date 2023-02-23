package 코딩테스트.동적프로그래밍.성공.일이삼더하기;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9095 성공!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] dy;
    static void input() {
        N = scan.nextInt();
        dy = new int[N + 5];
    }

    static void pro() {
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for(int i = 4; i <= N; i++){
            dy[i] = dy[i-3] + dy[i-2] + dy[i-1];
        }
        System.out.println(dy[N]);
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