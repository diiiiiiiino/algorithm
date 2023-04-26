package 코딩테스트.백준.이분탐색.다시풀기.이상한술집;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] a;

    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();

        a = new int[N + 1];

        for(int i = 1; i <= N; i++){
            a[i] = scan.nextInt();
        }
    }

    static boolean determine(long x){
        long count = 0;
        for(int i = 1; i <= N; i++){
            if(a[i] == 0) continue;
            count += a[i] / x;
        }

        return count >= K;
    }

    static void pro(){
        long L = 1, R = 0;
        long ans = 0;
        for(int i = 1; i <= N; i++){
            R = Math.max(a[i], R);
        }

        while(L <= R){
            long mid = (L + R) / 2;

            if(determine(mid)){
                ans = mid;
                L = mid + 1;
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