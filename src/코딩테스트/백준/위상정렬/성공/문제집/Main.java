package 코딩테스트.백준.위상정렬.성공.문제집;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1766 성공!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] adj;


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        indegree = new int[N + 1];
        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            adj[x].add(y);
            indegree[y]++;
        }
    }

    static void pro() {
        Queue<Integer> queue = new PriorityQueue<>();

        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            sb.append(x).append(" ");

            for(int y : adj[x]){
                indegree[y]--;

                if(indegree[y] == 0)
                    queue.add(y);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
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
