package 코딩테스트.백준.정렬.다시풀기.수고르기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2230 성공(힌트)!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static int[] nums;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N + 1];
        ans = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            nums[i] = scan.nextInt();
        }
    }

    static void func(){
        int L = 1, R = 1;

        while(L <= N && R <= N){
            int val = nums[R] - nums[L];

            if(val >= M){
                L++;
                ans = Math.min(ans, val);
            } else {
                R++;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(nums, 1, N + 1);
        func();
        System.out.println(ans);
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