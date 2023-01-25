package 코딩테스트.정렬;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1181
 */

public class BOJ1181 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] strings;

    static void input() {
        N = scan.nextInt();
        strings = new String[N];
        for(int i = 0; i < N; i++){
            strings[i] = scan.next();
        }
    }

    static void pro() {
        Arrays.sort(strings, (o1, o2) -> {
            if(o1.length() != o2.length()){
                return o1.length() - o2.length();
            }

            return o1.compareTo(o2);
        });

        for (int i = 0; i < N; i++) {
            if (i == 0 || !strings[i].equals(strings[i - 1]))
                sb.append(strings[i]).append('\n');
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
