package 코딩테스트.이분탐색.BOJ1654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 다시 풀기 https://www.acmicpc.net/problem/1654
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] A;

    static public void input(){
        K = scan.nextInt();
        N = scan.nextInt();
        A = new int[K + 1];
        for(int i = 1; i <= K; i++){
            A[i] = scan.nextInt();
        }
    }

    static public void pro(){


        System.out.println();
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
            br = new BufferedReader(new FileReader(s));
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