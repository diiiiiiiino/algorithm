package 코딩테스트.투포인터.BOJ2470;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int n;
    static int[] a;

    static void input() {
        n = scan.nextInt();
        a = new int[n + 1];
        for(int i = 1; i <= n; i++){
            a[i] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(a, 1, n + 1);
        int L = 1, R = n, v1 = 0, v2 = 0, bestSum = Integer.MAX_VALUE;

        while(L < R){
            int sum = a[L] + a[R];

            if(Math.abs(sum) < bestSum){
                bestSum = Math.abs(sum);
                v1 = a[L];
                v2 = a[R];
            }

            if(sum < 0){
                L++;
            } else {
                R--;
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb.toString());
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