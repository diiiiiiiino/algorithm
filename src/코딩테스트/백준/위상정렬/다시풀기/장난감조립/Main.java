package 코딩테스트.백준.위상정렬.다시풀기.장난감조립;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2637
 */
public class Main {
    static class Info{
        int y;
        int v;

        public Info(int y, int v){
            this.y = y;
            this.v = v;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Info>[] adj;
    static int[] indeg;
    static int[][] count;


    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        indeg = new int[N + 1];
        count = new int[N + 1][N + 1];

        for(int i = 1; i <= M; i++){
            int y = scan.nextInt(), x = scan.nextInt(), v = scan.nextInt();

            adj[x].add(new Info(y, v));
            indeg[y]++;
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indeg[i] == 0){
                queue.add(i);
                count[i][i] = 1;
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(Info info : adj[x]){
                int y = info.y, v = info.v;

                for(int i = 1; i <= N; i++){
                    count[y][i] += count[x][i] * v;
                }

                indeg[y]--;

                if(indeg[y] == 0) queue.add(y);
            }
        }

        for(int i = 1; i <= N; i++){
            if(count[N][i] != 0){
                System.out.println(i + " " + count[N][i]);
            }
        }
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