package 자바코딩인터뷰완벽가이드.배열과문자열.서러게이트페어에서코드포인트추출하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(extract("abcd"));
    }

    public static List<Integer> extract(String str){
        if(str == null || str.isBlank()) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            int cp = str.codePointAt(i);
            if(i < str.length() - 1 && str.codePointCount(i, i + 1) == 1){
                result.add(cp);
                result.add(str.codePointAt(i+1));
                i++;
            }
        }

        return result;
    }
}
