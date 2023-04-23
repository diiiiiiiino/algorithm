package 코딩테스트.백준.이분탐색.성공.예산;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2512
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] a;


    static void input(){
        N = scan.nextInt();
        a = new int[N + 1];

        for(int i = 1; i <= N; i++){
            a[i] = scan.nextInt();
        }

        M = scan.nextInt();
    }

    static boolean determine(int x){
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += Math.min(a[i], x);
        }

        return sum <= M;
    }

    static void pro(){
        int L = 1, R = 0, ans = 0;

        for(int i = 1; i <= N; i++){
            R = Math.max(a[i], R);
        }

        while(L <= R){
            int mid = (L + R) / 2;

            if(determine(mid)){
                L = mid + 1;
                ans = mid;
            } else {
                R = mid - 1;
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