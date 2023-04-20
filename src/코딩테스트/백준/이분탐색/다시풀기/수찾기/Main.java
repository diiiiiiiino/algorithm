package 코딩테스트.백준.이분탐색.다시풀기.수찾기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1920
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] nums, searches, ans;


    static void input(){
        N = scan.nextInt();
        nums = new int[N + 1];

        for(int i = 1; i <= N; i++){
            nums[i] = scan.nextInt();
        }

        M = scan.nextInt();
        searches = new int[M + 1];
        ans = new int[M + 1];

        for(int i = 1; i <= M; i++){
            searches[i] = scan.nextInt();
        }
    }

    static void binarySearch(int search, int idx){
        int L = 1, R = N;

        while(L <= R){
            int mid = (L + R) / 2;

            if(nums[mid] > search){
                R = mid - 1;
            } else if(nums[mid] < search) {
                L = mid + 1;
            } else {
                ans[idx] = 1;
                break;
            }
        }
    }

    static void pro(){
        Arrays.sort(nums, 1,N + 1);

        for(int i = 1; i <= M; i++){
            binarySearch(searches[i], i);
        }

        for(int i = 1; i <= M; i++){
            System.out.println(ans[i]);
        }
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