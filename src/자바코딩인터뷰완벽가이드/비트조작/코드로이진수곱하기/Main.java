package 자바코딩인터뷰완벽가이드.비트조작.코드로이진수곱하기;

public class Main {
    public static void main(String[] args) {
        int result = multiply(6, 3);
        System.out.println(result);
    }

    public static int multiply(int q, int p){
        int result = 0;

        while(p != 0 ){
            if((p & 1) != 0){
                result = result + q;
            }

            q = q << 1;
            p = p >>> 1;
        }

        return result;
    }
}
