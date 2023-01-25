package 코딩테스트.위상정렬.BOJ2623;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, count;
    static int[] degree;
    static int[][] orders;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        degree = new int[N + 1];
        adj = new ArrayList[N + 1];
        orders = new int[M + 1][];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            int pd = scan.nextInt();
            orders[i] = new int[pd + 1];

            for(int j = 1; j <= pd; j++ ){
                orders[i][j] = scan.nextInt();
            }
        }

        for(int i = 1; i <= M; i++){
            for(int j = 1; j < orders[i].length - 1; j++){
                int x = orders[i][j];
                int y = orders[i][j + 1];
                adj[x].add(y);
                degree[y]++;
            }
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(degree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            count++;
            sb.append(x).append("\n");

            for(int y : adj[x]){
                degree[y]--;
                if(degree[y] == 0)
                    queue.add(y);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();

        if(count != N){
            System.out.println(0);
        } else {
            System.out.println(sb.toString());
        }
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
