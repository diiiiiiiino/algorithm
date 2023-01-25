package 코딩테스트.이분탐색.BOJ1920;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static public void input(){
        N = scan.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }

        M = scan.nextInt();
        B = new int[M + 1];
        for(int i = 1; i <= M; i++){
            B[i] = scan.nextInt();
        }
    }

    static public void pro(){
        Arrays.sort(A, 1, N + 1);

        for(int i = 1; i <= M; i++){
            int L = 1;
            int R = N;

            int found = 0;
            while(L <= R){
                int mid = (L + R) / 2;

                if(A[mid] > B[i]){
                    R = mid - 1;
                } else if(A[mid] < B[i]) {
                    L = mid + 1;
                } else {
                    found = 1;
                    break;
                }
            }

            sb.append(found).append("\n");
        }
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
