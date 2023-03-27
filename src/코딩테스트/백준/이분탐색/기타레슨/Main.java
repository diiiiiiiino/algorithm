package 코딩테스트.백준.이분탐색.기타레슨;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12738 다시풀기
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] nums;
    static List<Integer> list = new ArrayList<>();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        for(int i = 1; i <= N; i++){
            nums[i] = scan.nextInt();
        }
    }

    static void func(){
        list.add(Integer.MIN_VALUE);

        for(int i = 1; i <= N; i++){
            int val = nums[i];

            if(val > list.get(list.size() - 1)){
                list.add(val);
            }else {
                int L = 1, R = list.size() - 1;
                while(L < R){
                    int mid = (L+R) / 2;
                    if(list.get(mid) >= val){
                        R = mid;
                    } else {
                        L = mid + 1;
                    }
                }
                list.set(R, val);
            }
        }
        System.out.println(list.size() - 1);
    }

    public static void main(String[] args) {
        input();
        func();
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