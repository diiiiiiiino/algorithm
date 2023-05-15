package 자바코딩인터뷰완벽가이드.배열과문자열;

import java.util.HashMap;
import java.util.Map;

public class 고유문자 {
    private static final int MAX_CODE = 65535;

    private 고유문자(){
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isUnique(String str){
        if(str == null || str.isBlank()){
            return false;
        }

        Map<Character, Boolean> chars = new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            if(str.codePointAt(i) <= MAX_CODE){
                char ch = str.charAt(i);
                if(!Character.isWhitespace(ch)){
                    Boolean result = chars.put(ch, true);
                    if(result != null){
                        return false;
                    }
                }
            } else {
                System.out.println("The given string contains unallowed characters");
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("ABC"));
    }
}
