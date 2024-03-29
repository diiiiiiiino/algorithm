package 자바코딩인터뷰완벽가이드.배열과문자열.문자열.고유문자2;

public class Main {
    private static final char A_CHAR = 'a';

    private Main(){
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isUnique(String str){
        if(str == null || str.isBlank()){
            return false;
        }

        int marker = 0;

        for(int i = 0; i < str.length(); i++){
            int s = str.charAt(i) - A_CHAR;
            int mask = 1 << s;

            if((marker & mask) > 0) {
                return false;
            }

            marker = marker | mask;
        }

        return true;
    }

    public static void main(String[] args) {
        isUnique("abb");
    }
}
