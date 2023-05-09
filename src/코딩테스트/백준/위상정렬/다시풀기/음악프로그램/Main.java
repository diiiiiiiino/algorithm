package 코딩테스트.백준.위상정렬.다시풀기.음악프로그램;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2623
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, count;
    static ArrayList<Integer>[] adj;
    static int[] indeg;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            int count = scan.nextInt();

            int x = 0;
            for(int j = 1; j <= count; j++){
                int y = scan.nextInt();

                if(x > 0){
                    adj[x].add(y);
                    indeg[y]++;
                }
                x = y;
            }
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indeg[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            sb.append(x).append("\n");
            count++;

            for(int y : adj[x]){
                indeg[y]--;

                if(indeg[y] == 0) queue.add(y);
            }
        }

        if(count == N){
            System.out.println(sb);
        } else {
            System.out.println(0);
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