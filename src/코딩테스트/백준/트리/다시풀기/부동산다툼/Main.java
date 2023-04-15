package 코딩테스트.백준.트리.다시풀기.부동산다툼;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20364
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static boolean[] checked;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();

        checked = new boolean[N + 1];
    }

    static void pro(){
        while(M-- > 0){
            int x = scan.nextInt(), res = 0;
            int y = x;

            while(x > 0){
                if(checked[x])
                    res = x;
                x >>= 1;
            }

            checked[y] = true;
            sb.append(res).append("\n");
        }
        System.out.println(sb);
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