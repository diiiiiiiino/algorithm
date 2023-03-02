package 코딩테스트.동적프로그래밍.다시풀기.암호코드;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2011
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] dy;
    static String[] nums;

    static void input() {
        String str = scan.next();
        nums = str.split("");
        N = nums.length;
        dy = new int[N + 1];
    }

    static void pro() {
        dy[1] = 1;
        dy[2] = Integer.parseInt(nums[1] + nums[2]) > 26 ? 1 : 2;

        for(int i = 3; i <= N; i++){
            dy[i] = dy[i-1] + (Integer.parseInt(nums[N-2] + nums[N-1]) > 26 ? 0 : 2);
        }

        System.out.println(dy[N]);
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