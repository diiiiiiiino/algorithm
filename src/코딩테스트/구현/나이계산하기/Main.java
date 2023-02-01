package 코딩테스트.구현.나이계산하기;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16199 성공!
 */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int birthYear, birthMonth, birthDay;
    static int baseYear, baseMonth, baseDay;

    static void input() {
        birthYear = scan.nextInt();
        birthMonth = scan.nextInt();
        birthDay = scan.nextInt();

        baseYear = scan.nextInt();
        baseMonth = scan.nextInt();
        baseDay = scan.nextInt();
    }

    static void pro1() {
        int age = baseYear - birthYear;

        if(baseYear > birthYear){
            if(baseMonth == birthMonth && baseDay < birthDay){
                age--;
            } else if(baseMonth < birthMonth){
                age--;
            }
        }

        sb.append(age).append("\n");
    }

    static void pro2() {
        int age = baseYear - birthYear + 1;
        sb.append(age).append("\n");
    }

    static void pro3() {
        int age = baseYear - birthYear;
        sb.append(age);
    }

    public static void main(String[] args) {
        input();
        pro1();
        pro2();
        pro3();
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
