package 코딩테스트.백준.완전탐색.성공.N과M10;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15664 성공!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] nums, selected, used;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N + 1];
        selected = new int[M + 1];
        used = new int[N + 1];
        for(int i = 1; i <= N; i++ ){
            nums[i] = scan.nextInt();
        }
    }

    static void rec_func(int k, int start) {
        if(M + 1 == k){
            for(int i = 1; i <= M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append("\n");
        } else {
            int last = 0;
            for(int i = start; i <= N; i++){
                if(used[i] == 1) continue;
                if(last == nums[i]) continue;

                last = nums[i];
                selected[k] = nums[i]; used[i] = 1;
                rec_func(k + 1, i);
                selected[k] = 0; used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(nums, 1, N + 1);
        rec_func(1, 1);
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