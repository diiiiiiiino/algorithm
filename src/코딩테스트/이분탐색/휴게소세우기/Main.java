package 코딩테스트.이분탐색.휴게소세우기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1477 다시풀기!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, L, ans;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        L = scan.nextInt();

        A = new int[N + 2];
        for(int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }
        A[N + 1] = L;

        Arrays.sort(A, 1, N + 2);
    }

    static boolean search(int mid){
        int count = 0;
        for(int i = 1; i < N + 2; i++){
            int diff = A[i] - A[i - 1] - 1;
            count += (diff / mid);
        }

        return count <= M;
    }

    static void pro() {
        int l = 1, r = L;
        while(l <= r){
            int mid = (l + r) / 2;
            if(search(mid)){
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
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