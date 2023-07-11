package 자바코딩인터뷰완벽가이드.배열과문자열.문자열.문자열요약하기;

public class Main {
    public static void main(String[] args) {
        System.out.println(shrink("abbb vvvv s rttt rr eee f"));
    }

    public static String shrink(String str){
        if(str == null || str.isBlank()){
            return "";
        }

        StringBuilder result = new StringBuilder();

        int count = 0;
        for(int i = 0; i < str.length(); i++){
            count++;

            if(!Character.isWhitespace(str.charAt(i))){
                if((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)){
                    result.append(str.charAt(i)).append(count);

                    count = 0;
                }
            } else {
                result.append(str.charAt(i));
                count = 0;
            }
        }

        return result.length() > str.length() ? str : result.toString();
    }
}
