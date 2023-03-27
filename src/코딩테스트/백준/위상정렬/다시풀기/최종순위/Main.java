package 코딩테스트.백준.위상정렬.다시풀기.최종순위;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3665 다시풀기!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb;

    static int N, M;
    static int[] indegree, nums;
    static ArrayList<Integer>[] adj;


    static void input() {
        sb = new StringBuilder();
        N = scan.nextInt();
        nums = new int[N + 1];
        adj = new ArrayList[N + 1];
        indegree = new int[N + 1];
        for(int i = 1; i <= N; i++){
            nums[i] = scan.nextInt();
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++){
            for(int j = i + 1; j <= N; j++){
                adj[nums[i]].add(nums[j]);
                indegree[nums[j]]++;
            }
        }

        M = scan.nextInt();
        for(int i = 0; i < M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            if(adj[x].contains(y)){
                adj[x].remove((Integer) x);
                adj[y].add(x);
                indegree[x]++;
                indegree[y]--;
            } else {
                adj[y].remove((Integer) x);
                adj[x].add(y);
                indegree[y]++;
                indegree[x]--;
            }
        }
    }

    static void pro() {
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0) deque.add(i);
        }

        int count = 0;
        while(!deque.isEmpty()){
            int x = deque.poll();

            sb.append(x).append(" ");
            count++;

            for(int y : adj[x]){
                indegree[y]--;
                if(indegree[y] == 0) deque.add(y);
            }
        }

        if(count != N){
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for(int i = 1; i <= T; i++){
            input();
            pro();
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
