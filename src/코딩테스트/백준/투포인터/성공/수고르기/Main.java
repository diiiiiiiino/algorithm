package 코딩테스트.백준.투포인터.성공.수고르기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2230
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] a;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N + 1];

        for(int i = 1; i <= N; i++){
            a[i] = scan.nextInt();
        }

        Arrays.sort(a, 1, N + 1);
    }

    static void pro(){
        int R = 2, ans = 2_000_000_000;
        for(int L = 1; L <= N; L++){
            while(R <= N){
                if(a[R] - a[L] >= M){
                    ans = Math.min(ans, a[R] - a[L]);
                    break;
                } else {
                    R++;
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args){
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