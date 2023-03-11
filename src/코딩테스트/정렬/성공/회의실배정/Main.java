package 코딩테스트.정렬.성공.회의실배정;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1931
 */
public class Main {
    static class Time implements Comparable<Time>{
        int start;
        int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Time time){
            if(this.end != time.end){
                return this.end - time.end;
            }

            return this.start - time.start;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Time[] times;

    static void input() {
        N = scan.nextInt();
        times = new Time[N + 1];

        for(int i = 1; i <= N; i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            times[i] = new Time(start, end);
        }

        Arrays.sort(times, 1, N + 1);
    }

    static void pro() {
        int count = 1;
        Time time = times[1];
        for(int i = 2; i <= N; i++){
            if(time.end <= times[i].start){
                time = times[i];
                count++;
            }
        }
        System.out.println(count);
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