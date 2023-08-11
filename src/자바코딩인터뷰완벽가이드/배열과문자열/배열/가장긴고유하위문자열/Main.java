package 자바코딩인터뷰완벽가이드.배열과문자열.배열.가장긴고유하위문자열;

public class Main {
    private static final int ASCII_CODES = 256;

    public static String longestDistinctSubstring(String str){
        if(str == null || str.isBlank()) {
            return "";
        }

        boolean[] flagWindow = new boolean[ASCII_CODES];

        int left = 0;
        int right = 0;
        for(int wl = 0, wr = 0; wr < str.length(); wr++){
            if(flagWindow[str.charAt(wr)]){
                while(str.charAt(wl) != str.charAt(wr)){
                    flagWindow[str.charAt(wl)] = false;
                    wl++;
                }

                wl++;
            } else {
                flagWindow[str.charAt(wr)] = true;

                if((right - left) < (wr - wl)){
                    left = wl;
                    right = wr;
                }
            }
        }

        return str.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String str = "abcc#$%^&ccdbeeebdd012333dbsssbesbaas";

        String result = longestDistinctSubstring(str);

        System.out.println("String: " + str);
        System.out.println("Result: " + result);
    }
}
