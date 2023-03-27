package 코딩테스트.백준.트리.다시풀기.트리의순회;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2263 다시풀기!!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] inOrder, postOrder, indexes;

    static void input() {
        N = scan.nextInt();
        inOrder = new int[N + 1];
        postOrder = new int[N + 1];
        indexes = new int[N + 1];
        for(int i = 1; i <= N; i++){
            inOrder[i] = scan.nextInt();
            indexes[inOrder[i]] = i;
        }

        for(int i = 1; i <= N; i++){
            postOrder[i] = scan.nextInt();
        }
    }

    static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd){
            return;
        }

        int rootIdx = indexes[postOrder[postEnd]];
        int leftSize = rootIdx - inStart;
        int rightSize = inEnd - rootIdx;

        sb.append(inOrder[rootIdx]).append(" ");

        preOrder(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);
        preOrder(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
    }

    public static void main(String[] args) {
        input();
        preOrder(1, N, 1, N);
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