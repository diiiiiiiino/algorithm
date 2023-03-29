package 코딩테스트.백준.그래프.다시풀기.양;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3184
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C, vCount, oCount, vAns, oAns;
    static String[][] a;
    static boolean[][] visited;
    static int[][] dir = { {-1,0}, {0,1}, {1,0}, {0,-1}};

    static void input(){
        R = scan.nextInt();
        C = scan.nextInt();
        a = new String[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            a[i] = scan.next().split("");
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        if(a[x][y].equals("v")) vCount++;
        if(a[x][y].equals("o")) oCount++;

        for(int i = 0; i < 4; i++){
            int nx = dir[i][0] + x;
            int ny = dir[i][1] + y;

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(visited[nx][ny]) continue;
            if(a[nx][ny].equals("#")) continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args){
        input();
        for(int x = 0; x < R; x++){
            for(int y = 0; y < C; y++){
                if(visited[x][y]) continue;
                if(a[x][y].equals("#")) continue;
                vCount = 0;
                oCount = 0;
                System.out.println("dfs start " + x + "," + y);
                dfs(x, y);
                System.out.println("dfs end " + x + "," + y);
                if(oCount > vCount){
                    oAns += oCount;
                } else {
                    vAns += vCount;
                }
            }
        }
        sb.append(oAns).append(" ").append(vAns);
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