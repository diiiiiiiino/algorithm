package 코딩테스트.그래프.BOJ3055;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, dx, dy;
    static String[] a;
    static int[][] dist_water, dist_hedgehog;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][M];
        dist_water = new int[N][M];
        dist_hedgehog = new int[N][M];
    }

    // 모든 물들을 시작으로 동시에 BFS 시작!
    static void bfs_water() {
        Queue<Integer> Q = new LinkedList<>();
        // 모든 물의 위치를 Q에 전부 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_water 와 visit 배열 초기화
                dist_water[i][j] = -1;
                visit[i][j] = false;
                /* TODO */
                if (a[i].charAt(j) == '*') {
                    /* TODO */
                    Q.add(i);
                    Q.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                } else if(a[i].charAt(j) == 'D'){
                    dx = i;
                    dy = j;
                }
            }
        }

        // BFS 과정 시작
        /* TODO */
        while(!Q.isEmpty()){
            int x = Q.poll(), y = Q.poll();

            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0], ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(a[nx].charAt(ny) != '.') continue;

                dist_water[nx][ny] = dist_water[x][y] + 1;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }

    // 고슴도치를 시작으로 동시에 BFS 시작!
    static void bfs_hedgehog() {
        Queue<Integer> Q = new LinkedList<>();
        // 고슴도치 위치를 Q에 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_hedgehog 와 visit 배열 초기화
                dist_hedgehog[i][j] = -1;
                visit[i][j] = false;
                /* TODO */
                if (a[i].charAt(j) == 'S') {
                    /* TODO */
                    Q.add(i);
                    Q.add(j);

                    dist_hedgehog[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        // BFS 과정 시작
        /* TODO */
        while(!Q.isEmpty()){
            int x = Q.poll(), y = Q.poll();

            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0], ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(a[nx].charAt(ny) == 'X' || a[nx].charAt(ny) == '*') continue;
                if(dist_water[nx][ny] != -1 && dist_hedgehog[x][y] + 1 >= dist_water[nx][ny]) continue;

                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }

    static void pro() {
        // 각 칸마다 물에 닿는 시간 계산하기
        bfs_water();

        // 고슴도치가 물을 피해 탐색할 수 있는 공간 찾기
        bfs_hedgehog();

        // 탈출구 'D' 에 대한 결과를 통해 정답 출력하기
        if(dist_hedgehog[dx][dy] == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(dist_hedgehog[dx][dy]);
        }
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