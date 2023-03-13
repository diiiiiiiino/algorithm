package 코딩테스트.이분탐색.성공.숫자카드;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10815
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B, ans;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }

        M = scan.nextInt();
        B = new int[M + 1];
        ans = new int[M + 1];
        for(int i = 1; i <= M; i++){
            B[i] = scan.nextInt();
        }

        Arrays.sort(A, 1, N + 1);
    }

    static void search(int num, int i){
        int L = 1, R = N;
        while(L <= R){
            int mid = (L + R) / 2;

            if(A[mid] < num){
                L = mid + 1;
            } else if(A[mid] > num){
                R = mid - 1;
            } else {
                ans[i] = 1;
                break;
            }
        }
    }

    static void pro() {
        for(int i = 1; i <= M; i++){
            search(B[i], i);
        }

        for(int i = 1; i <= M; i++){
            System.out.print(ans[i] + " ");
        }
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