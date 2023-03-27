package 코딩테스트.백준.동적프로그래밍.다시풀기.일로만들기;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1463
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] dy;
    static void input() {
        N = scan.nextInt();
        dy = new int[N + 1];
    }

    static void pro() {
        dy[1] = 0;

        for(int i = 2; i <= N; i++){
            dy[i] = dy[i - 1] + 1;

            if(i % 3 == 0){
                dy[i] = Math.min(dy[i], dy[i / 3] + 1);
            }
            if(i % 2 == 0) {
                dy[i] = Math.min(dy[i], dy[i / 2] + 1);
            }
        }
        System.out.println(dy[N]);
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