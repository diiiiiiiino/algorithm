package 코딩테스트.정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11652
 */
public class BOJ11652 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] nums;
    static long count, min = Integer.MAX_VALUE;
    static long prevNum, prevCount;


    static void input() {
        N = scan.nextInt();
        nums = new long[N + 1];
        for(int i = 1; i <= N; i++){
            nums[i] = scan.nextLong();
        }
    }

    static void pro() {
        long mode = nums[1];
        int modeCnt = 1, curCnt = 1;

        for(int i = 2; i <= N; i++){
            if(nums[i - 1] == nums[i]){
                curCnt++;
            } else {
                curCnt = 1;
            }

            if(curCnt > modeCnt){
                modeCnt = curCnt;
                mode = nums[i];
            }
        }

        System.out.println(mode);
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(nums, 1, N + 1);  // Sort

        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));
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
