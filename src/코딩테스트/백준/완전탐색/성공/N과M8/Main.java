package 코딩테스트.백준.완전탐색.성공.N과M8;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15657 성공!
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] selected, nums;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N + 1];
        for(int i = 1; i <= N; i++){
            nums[i] = scan.nextInt();
        }

        selected = new int[M + 1];
    }

    static void recFunc(int K, int start){
        if(M + 1 == K){
            for(int i = 1; i <= M; i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int i = start; i <= N; i++){
                selected[K] = nums[i];
                recFunc(K + 1, i);
                selected[K] = 0;
            }
        }
    }

    public static void main(String[] args){
        input();
        Arrays.sort(nums, 1, N + 1);
        recFunc(1, 1);
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
