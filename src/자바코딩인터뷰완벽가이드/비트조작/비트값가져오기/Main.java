package 자바코딩인터뷰완벽가이드.비트조작.비트값가져오기;

public class Main {
    public static void main(String[] args) {
        char result = getValue(423, 7);
        System.out.println(result);
    }

    public static char getValue(int n, int k){
        if(k < 0 || k > 31){
            throw new IllegalArgumentException("The position must be between 0 ans 31");
        }

        int result = 1 & (n >> k);

        if(result == 0){
            return '0';
        }

        return '1';
    }
}
