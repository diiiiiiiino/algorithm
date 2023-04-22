package 코딩테스트.백준.이분탐색.다시풀기.숫자카드2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10816
 */
public class Retry {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] a, b;

    static void input(){
        N = scan.nextInt();
        a = new int[N + 1];

        for(int i = 1; i <= N; i++){
            a[i] = scan.nextInt();
        }

        M = scan.nextInt();
        b = new int[M + 1];

        for(int i = 1; i <= M; i++){
            b[i] = scan.nextInt();
        }

        Arrays.sort(a, 1, N + 1);
    }

    static int binarySearch(int search){
        int L = 1, R = N;

        int ans = 0;
        while(L <= R){
            int mid = (L + R) / 2;

            if(a[mid] >= search){
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }

        return ans;
    }

    static int binarySearch2(int search){
        int L = 1, R = N;

        int ans = 0;
        while(L <= R){
            int mid = (L + R) / 2;

            if(a[mid] > search){
                R = mid - 1;
            } else {
                L = mid + 1;
                ans = mid;
            }
        }

        return ans;
    }

    static void pro(){
        for(int i = 1; i <= M; i++){
            int start = binarySearch(b[i]);
            int end = binarySearch2(b[i]);
            sb.append(end - start + 1).append(" ");
        }
    }

    public static void main(String[] args){
        input();
        pro();
        System.out.println(sb);
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