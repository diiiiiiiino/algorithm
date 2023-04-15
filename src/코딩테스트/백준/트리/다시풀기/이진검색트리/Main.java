package 코딩테스트.백준.트리.다시풀기.이진검색트리;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5639
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer> a;

    static void input() throws IOException {
        a = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while ((input = br.readLine()) != null){
            a.add(Integer.parseInt(input));
        }
    }

    static void travers(int l, int r){
        if(l > r) return;

        int mid = r;
        for(int i = l + 1; i <= r; i++){
            if(a.get(i) > a.get(l)){
                mid = i - 1;
                break;
            }
        }

        travers(l + 1, mid);
        travers(mid + 1, r);
        sb.append(a.get(l)).append("\n");
    }

    public static void main(String[] args) throws IOException {
        input();
        travers(0, a.size() - 1);
        System.out.println(sb.toString());
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