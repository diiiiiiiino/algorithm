package 코딩테스트.이분탐색.BOJ3273;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, X;
    static int[] A;

    static public void input(){
        N = scan.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }

        X = scan.nextInt();
    }

    public static boolean binarySearch(int L, int R, int num){
        while(L <= R){
            int mid = (L + R) / 2;

            if(num < A[mid] && num + A[mid] == X) return true;
            if(A[mid] + num < X){
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return false;
    }

    static public void pro(){
        Arrays.sort(A, 1, N + 1);

        int count = 0;
        for(int i = 1; i <= N; i++){
            int L = 1, R = N;

            if(binarySearch(L, R, A[i]))
                count++;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb.toString());
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
