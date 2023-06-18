package 자바코딩인터뷰완벽가이드.비트조작.코드로이진수빼기;

public class Main {
    public static void main(String[] args) {
        int result = subtract(4, 2);
        System.out.println(result);
    }

    public static int subtract(int q, int p){
        while(p != 0){
            int borrow = (~q) & p;

            q = q ^ p;

            p = borrow << 1;
        }

        return q;
    }
}
