package 코딩테스트.정렬.성공.좌표정렬하기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11650 성공!
 */

public class Main {
    static class Point implements Comparable<Point>{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if(this.x != point.x){
                return this.x - point.x;
            }

            return this.y - point.y;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Point[] points;

    static void input() {
        N = scan.nextInt();
        points = new Point[N + 1];
        for(int i = 1; i <= N; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            points[i] = new Point(x, y);
        }
    }

    static void func(){
        Arrays.sort(points, 1, N + 1);
        for(int i = 1; i <= N; i++){
            sb.append(points[i].x)
                    .append(" ")
                    .append(points[i].y)
                    .append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        func();
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