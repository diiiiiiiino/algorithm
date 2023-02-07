package 코딩테스트.이분탐색.가장긴증가하는부분수열3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12738
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static int[] nums;

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        for(int i = 1; i <= N; i++){
            nums[i] = scan.nextInt();
        }

        Arrays.sort(nums, 1, N + 1);
    }

    static int upperBound(int a){
        int L = 1, R = N, retVal = 0;
        while(L <= R){
            int mid = (L + R) / 2;

            if(a > nums[mid]){
                L = mid + 1;
            } else {
                R = mid - 1;
                retVal = mid;
                break;
            }
        }
        return retVal;
    }

    static int bottomBound(int a){
        int L = 1, R = N, retVal = 0;
        while(L <= R){
            int mid = (L + R) / 2;

            if(a >= nums[mid]){
                L = mid + 1;
                retVal = mid;
            } else {
                R = mid - 1;
            }
        }
        return retVal;
    }

    static void func(){
        ans = upperBound(nums[N]) - bottomBound(nums[1]);
    }

    public static void main(String[] args) {
        input();
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