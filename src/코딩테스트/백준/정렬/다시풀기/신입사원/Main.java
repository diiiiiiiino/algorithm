package 코딩테스트.백준.정렬.다시풀기.신입사원;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1946 실패
 */
public class Main {
    static FastReader scan = new FastReader();

    static int N, ans;
    static int[] ranks;

    static void input() {
        N = scan.nextInt();
        ranks = new int[N + 1];
        for(int i = 1; i <= N; i++){
            int rank1 = scan.nextInt();
            int rank2 = scan.nextInt();
            ranks[rank1] = rank2;
        }
    }

    static void func(){
        ans = 1;

        for(int i = 1; i < N; i++){
            if(ranks[i] > ranks[i + 1]){
                ans++;
            }
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for(int i = 1; i <= T; i++){
            input();
            func();
            System.out.println(ans);
        }
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