package 코딩테스트.이분탐색.BOJ1764;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A, B;

    static public void input(){
        N = scan.nextInt();
        M = scan.nextInt();

        A = new String[N + 1];
        B = new String[M + 1];

        for(int i = 1; i <= N; i++){
            A[i] = scan.nextLine();
        }

        for(int i = 1; i <= M; i++){
            B[i] = scan.nextLine();
        }
    }

    static public boolean binarySearch(int L, int R, String aVal){
        while(L <= R){
            int mid = (L + R) / 2;

            if(aVal.equals(B[mid]))
                return true;

            if(aVal.compareTo(B[mid]) < 0){
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return false;
    }

    static public void pro(){
        Arrays.sort(A, 1, N + 1);
        Arrays.sort(B, 1, M + 1);

        int count = 0;
        for(int i = 1; i <= N; i++){
            int L = 1, R = M;

            if(binarySearch(L, R, A[i])) {
                count++;
                sb.append(A[i]).append("\n");
            }
        }

        sb.insert(0, count + "\n");

        System.out.println(sb.toString());
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