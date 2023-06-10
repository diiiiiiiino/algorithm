package 자바코딩인터뷰완벽가이드.비트조작.비트값초기화하기;

public class Main {
    public static void main(String[] args) {
        int result = clearFromMsb(423, 6);
        String binaryResult = Integer.toString(result, 2);
        System.out.println(binaryResult);

        int result2 = clearFromPosition(423, 6);
        String binaryResult2 = Integer.toString(result2, 2);
        System.out.println(binaryResult2);
    }

    public static int clearFromMsb(int n, int k){
        if(k < 0 || k > 31){
            throw new IllegalArgumentException("The position must be between 0 and 31");
        }

        return n & ((1 << k) - 1);
    }

    public static int clearFromPosition(int n, int k){
        if(k < 0 || k > 31){
            throw new IllegalArgumentException("The position must be between 0 and 31");
        }

        return n & ~((1 << k) - 1);
    }
}
