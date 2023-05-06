package 코딩테스트.백준.투포인터.다시풀기.두수의합;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3273
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, x;
    static int[] a;

    static void input(){
        n = scan.nextInt();
        a = new int[n + 1];

        for(int i = 1; i <= n; i++){
            a[i] = scan.nextInt();
        }

        x = scan.nextInt();
    }

    static void pro(){
        int L = 0, R = 0, ans = 0;

        while(L <= n && R <= n){
            int sum = a[L] + a[R];

            if(sum == x){
                ans++;
                L++;
            } else if(sum < x){
                R++;
            } else {
                R--;
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