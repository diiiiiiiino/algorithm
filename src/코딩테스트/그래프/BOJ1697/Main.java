package 코딩테스트.그래프.BOJ1697;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static boolean[] visit;
    static int[] time;
    static int[] dir = { -1, 1, 2 };

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();

        visit = new boolean[100005];
        time = new int[100005];
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int i = 0; i < 3; i++){
                int nx = (i == 2 ? x * dir[i] : x + dir[i]);

                if(nx < 0 || nx > 100000) continue;

                if(visit[nx]){
                    time[nx] = Math.min(time[nx], time[x] + 1);
                } else {
                    visit[nx] = true;
                    time[nx] = time[x] + 1;
                    queue.add(nx);
                }
            }
        }
    }

    static void pro() {
        bfs(N);
        System.out.println(time[K]);
    }

    public static void main(String[] args) {
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
