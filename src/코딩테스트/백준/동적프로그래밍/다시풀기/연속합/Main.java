package 코딩테스트.백준.동적프로그래밍.다시풀기.연속합;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1912
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans = Integer.MIN_VALUE;
    static int[] dy, nums;
    static void input() {
        N = scan.nextInt();
        dy = new int[N + 1];
        nums = new int[N + 1];
        for(int i = 1; i<= N; i++){
            nums[i] = scan.nextInt();
        }
    }

    static void pro() {
        dy[1] = nums[1];
        ans = dy[1];

        for(int i = 2; i <= N; i++){
            dy[i] = Math.max(dy[i - 1] + nums[i], nums[i]);
            ans = Math.max(dy[i], ans);
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