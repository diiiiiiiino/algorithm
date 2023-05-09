package 코딩테스트.백준.위상정렬.다시풀기.strahler순서;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9470
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, M, P, ans;
    static int[] indeg, strahler, maxCnt;
    static ArrayList<Integer>[] adj;

    static void input(){
        K = scan.nextInt();
        M = scan.nextInt();
        P = scan.nextInt();

        adj = new ArrayList[M + 1];
        for(int i = 1; i <= M; i++) adj[i] = new ArrayList<>();
        indeg = new int[M + 1];
        strahler = new int[M + 1];
        maxCnt = new int[M + 1];

        for(int i = 1; i <= P; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= M; i++){
            if(indeg[i] == 0) {
                queue.add(i);
                strahler[i] = maxCnt[i] = 1;
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            if(maxCnt[x] >= 2){
                strahler[x]++;
            }

            for(int y : adj[x]){
                indeg[y]--;

                if(indeg[y] == 0) queue.add(y);

                if(strahler[y] == strahler[x]){
                    maxCnt[y]++;
                } else if(strahler[y] < strahler[x]){
                    strahler[y] = strahler[x];
                    maxCnt[y] = 1;
                }
            }

        }

        System.out.println(K + " " + strahler[M]);
    }

    public static void main(String[] args){
        int T = scan.nextInt();

        while(T-- > 0){
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