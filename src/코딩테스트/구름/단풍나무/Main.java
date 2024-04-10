package 코딩테스트.구름.단풍나무;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://level.goorm.io/exam/167345/%EB%8B%A8%ED%92%8D%EB%82%98%EB%AC%B4/quiz/1
 */
public class Main {
    static int N;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] bfs(int[][] graph, int sx, int sy, boolean[][] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(sx, sy));
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    if (graph[nx][ny] == 0) {
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    } else {
                        graph[nx][ny]--;
                        if (graph[nx][ny] == 0) {
                            graph[nx][ny] = -1;
                        }
                    }
                }
            }
        }

        return graph;
    }

    static boolean check(int[][] graph) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[][] color(int[][] graph) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] < 0) {
                    graph[i][j] = 0;
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        N = scanner.nextInt();
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        while (check(graph)) {
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 0 && !visited[i][j]) {
                        graph = bfs(graph, i, j, visited);
                    }
                }
            }
            graph = color(graph);
            answer++;
        }
        System.out.println(answer);
    }
}