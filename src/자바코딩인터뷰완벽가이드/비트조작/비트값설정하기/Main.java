package 자바코딩인터뷰완벽가이드.비트조작.비트값설정하기;

public class Main {
    public static int setValueTo0(int n, int k){
        if(k < 0 || k > 31){
            throw new IllegalArgumentException("The position must be between 0 ans 31");
        }

        return n & ~(1 << k);
    }

    public static int setValueTo1(int n, int k){
        if(k < 0 || k > 31){
            throw new IllegalArgumentException("The position must be between 0 ans 31");
        }

        return n | (1 << k);
    }
}
