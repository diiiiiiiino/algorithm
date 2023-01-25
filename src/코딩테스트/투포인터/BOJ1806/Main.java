package 코딩테스트.투포인터.BOJ1806;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int n, S;
    static int[] a;

    static void input() {
        n = scan.nextInt();
        S = scan.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void pro() {
        int R = 0, sum = 0, ans = n + 1;
        for (int L = 1; L <= n; L++) {
            sum -= a[L - 1];

            while(R < n && sum < S){
                R++;
                sum += a[R];
            }

            if(sum >= S){
                ans = Math.min(ans, R - L + 1);
            }
        }

        // ans 값을 보고 불가능 판단하기
        if(ans == n + 1){
            ans = 0;
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