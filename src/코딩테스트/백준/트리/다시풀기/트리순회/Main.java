package 코딩테스트.백준.트리.다시풀기.트리순회;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1991
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] adj;

    static void input(){
        N = scan.nextInt();
        adj = new int[N + 1][2];

        for(int i = 1; i <= N; i++){
            char cur = scan.next().charAt(0);

            int x = cur - 'A';
            for(int j = 0; j < 2; j++){
                char ch = scan.next().charAt(0);

                if(ch != '.') adj[x][j] = ch - 'A';
                else adj[x][j] = -1;
            }
        }

    }

    static void midOrder(int x){
        if(x == -1) return;
        midOrder(adj[x][0]);
        sb.append((char)(x + 'A'));
        midOrder(adj[x][1]);
    }

    static void preOrder(int x){
        if(x == -1) return;
        sb.append((char)(x + 'A'));
        preOrder(adj[x][0]);
        preOrder(adj[x][1]);
    }

    static void postOrder(int x){
        if(x == -1) return;
        postOrder(adj[x][0]);
        postOrder(adj[x][1]);
        sb.append((char)(x + 'A'));
    }

    public static void main(String[] args){
        input();
        preOrder(0);
        sb.append("\n");
        midOrder(0);
        sb.append("\n");
        postOrder(0);
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