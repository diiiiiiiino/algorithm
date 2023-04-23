package 코딩테스트.백준.이분탐색.성공.랜선자르기;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1654
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] a;

    static void input(){
        K = scan.nextInt();
        N = scan.nextInt();

        a = new int[K + 1];

        for(int i = 1; i <= K; i++){
            a[i] = scan.nextInt();
        }
    }

    static boolean search(long x){
        long sum = 0;
        for(int i = 1; i <= K; i++){
            sum += a[i] / x;
        }

        return sum >= N;
    }

    static void pro(){
        long L = 1, R = Integer.MAX_VALUE, ans = 0;

        while(L <= R){
            long mid = (L + R) / 2;

            if(search(mid)){
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