package 코딩테스트.정렬;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1181
 */

public class BOJ20291 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] strings;

    static void input() {
        N = scan.nextInt();
        strings = new String[N + 1];
        for(int i = 1; i <= N; i++){
            strings[i] = scan.nextLine().split("\\.")[1];
        }
    }

    static void pro() {
        Arrays.sort(strings, 1, N + 1);

        for(int i = 1; i <= N;){
            int cnt = 1, j = i + 1;
            for(; j <= N; j++){
                if(strings[j].compareTo(strings[i]) == 0) cnt++;
                else break;
            }

            sb.append(strings[i]).append(" ").append(cnt).append('\n');

            i = j;
        }

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
