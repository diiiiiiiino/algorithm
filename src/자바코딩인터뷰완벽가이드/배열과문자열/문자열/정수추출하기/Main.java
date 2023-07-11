package 자바코딩인터뷰완벽가이드.배열과문자열.문자열.정수추출하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(extract("cv dd 4 k 2321 2 11 k4k2 66 4d"));
    }

    public static List<Integer> extract(String str){
        if(str == null || str.isBlank()) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        StringBuilder temp = new StringBuilder(String.valueOf(Integer.MAX_VALUE).length());

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                temp.append(ch);
            } else {
                if(temp.length() > 0){
                    result.add(Integer.parseInt(temp.toString()));
                    temp.delete(0, temp.length());
                }
            }
        }

        return result;
    }
}
