package 코딩테스트.위상정렬.성공.작업;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2056 성공!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb;

    static int N;
    static int[] indegree, times, ans;
    static ArrayList<Integer>[] adj;


    static void input() {
        N = scan.nextInt();
        indegree = new int[N + 1];
        times = new int[N + 1];
        ans = new int[N + 1];
        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int x = 1; x <= N; x++){
            int time = scan.nextInt();
            int size = scan.nextInt();

            times[x] = time;
            for(int i = 1; i <= size; i++){
                int y = scan.nextInt();
                adj[y].add(x);
                indegree[x]++;
            }

            ans[x] = Integer.MIN_VALUE;
        }
    }

    static void pro() {
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0) {
                deque.add(i);
                ans[i] = times[i];
            }
        }

        while(!deque.isEmpty()){
            int x = deque.poll();

            for(int y : adj[x]){
                ans[y] = Math.max(ans[y], ans[x] + times[y]);

                indegree[y]--;

                if(indegree[y] == 0) deque.add(y);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();

        Arrays.sort(ans, 1, N + 1);
        System.out.println(ans[N]);
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
