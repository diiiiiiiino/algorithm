package 코딩테스트.완전탐색.성공.모든순열;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10974
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] nums;
    static boolean[] used;

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        used = new boolean[N + 1];
    }

    static void rec_func(int k) {
        if(k == N + 1){
            for(int i = 1; i <= N; i++) sb.append(nums[i]).append(" ");
            sb.append("\n");
        } else {
            for(int i = 1; i <= N; i++){
                if(used[i]) continue;

                nums[k] = i; used[i] = true;
                rec_func(k + 1);
                nums[k] = 0; used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
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