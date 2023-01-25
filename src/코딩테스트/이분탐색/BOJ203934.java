package 코딩테스트.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ203934 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int N, M;
    static int[] A, B;

    static public void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];

        for(int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }

        for(int i = 1; i <= M; i++){
            B[i] = scan.nextInt();
        }
    }

    static int lower_bound(int L, int R, int X){
        int result = L - 1;
        while(L <= R){
            int mid = (L + R) / 2;

            if(B[mid] < X){
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return result;
    }

    static public void pro(){
        Arrays.sort(B, 1, M + 1);

        int ans = 0;
        for(int i = 1; i <= N; i++ ){
            ans += lower_bound(1, M, A[i]);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        T = scan.nextInt();
        for(int i = 1; i <= T; i++){
            input();
            pro();
        }
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
