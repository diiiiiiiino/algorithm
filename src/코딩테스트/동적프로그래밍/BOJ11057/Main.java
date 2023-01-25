package 코딩테스트.동적프로그래밍.BOJ11057;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Dy;
    static int[] A;

    static void input(){
        N = scan.nextInt();
        Dy = new int[N + 1][10];
        A = new int[N + 1];
    }

    static void pro() {
        for(int num = 0; num <= 9; num++){
            Dy[1][num] = 1;
        }

        for(int len = 2; len <= N; len++){
            for(int num = 0; num <= 9; num++){
                for(int prev = 0; prev <= num; prev++){
                    Dy[len][num] += Dy[len-1][prev];
                    Dy[len][num] %= 10007;
                }
            }
        }

        int ans = 0;
        for(int num = 0; num <= 9; num++){
            ans += Dy[N][num];
            ans %= 10007;
        }

        System.out.println(ans);

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
