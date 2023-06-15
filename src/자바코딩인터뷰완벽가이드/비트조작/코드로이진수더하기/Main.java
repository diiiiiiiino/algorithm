package 자바코딩인터뷰완벽가이드.비트조작.코드로이진수더하기;

public class Main {
    public static void main(String[] args) {
        int result = sum(3, 4);
        System.out.println(result);
    }

    public static int sum(int q, int p){
        int xor;
        int and;
        int t;

        and = q & p;
        xor = q ^ p;

        while(and != 0){
            and = and << 1;

            t = xor ^ and;
            and = and & xor;
            xor = t;
        }

        return xor;
    }
}
