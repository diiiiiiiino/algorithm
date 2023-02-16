package 코딩테스트.위상정렬.다시풀기.게임개발;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1516 다시풀기 (이해는 됨)!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] indegree, times, ans;
    static ArrayList<Integer>[] adj, build;


    static void input() {
        N = scan.nextInt();
        indegree = new int[N + 1];
        times = new int[N + 1];
        ans = new int[N + 1];
        adj = new ArrayList[N + 1];
        build = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
            ans[i] = Integer.MIN_VALUE;
        }

        for(int i = 1; i <= N; i++){
            times[i] = scan.nextInt();
            while(true){
                int x = scan.nextInt();
                if(x == -1) break;

                adj[x].add(i);
                indegree[i]++;
            }
        }
    }

    static void pro() {
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                deque.add(i);
                ans[i] = times[i]; //시작되는 정점에 건설 시간을 대입 해줘야 함
            }
        }

        //ans[1] = times[1]; //이 부분이 틀림
        while(!deque.isEmpty()){
            int x = deque.poll();

            for(int y : adj[x]){
                /* 최소 시간이라고 해서 min으로 하는것이 아니라 문제에 맞게 해야한다. 
                   이 문제에서는 건물을 동시에 지을수 있기때문에 동시에 지어진 건물의 최대 시간을 더해줘야 한다
                */
                ans[y] = Math.max(ans[y], ans[x] + times[y]);  

                indegree[y]--;
                if(indegree[y] == 0) deque.add(y);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        for(int i = 1; i <= N; i++){
            System.out.println(ans[i]);
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
