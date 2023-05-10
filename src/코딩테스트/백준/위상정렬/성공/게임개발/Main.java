package 코딩테스트.백준.위상정렬.성공.게임개발;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1516
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] indeg, times, buildTime;

    static void input(){
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        times = new int[N + 1];
        buildTime = new int[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++){
            int x;
            int count = 1;
            while((x = scan.nextInt()) != -1){
                if(count == 1){
                    times[i] = x;
                } else if(count > 1) {
                    adj[x].add(i);
                    indeg[i]++;
                }

                count++;
            }
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList();
        for(int i = 1; i <= N; i++){
            if(indeg[i] == 0) {
                queue.add(i);
                buildTime[i] = times[i];
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int y : adj[x]){
                indeg[y]--;

                buildTime[y] = Math.max(times[y] + buildTime[x], buildTime[y]);

                if(indeg[y] == 0) queue.add(y);
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.println(buildTime[i]);
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