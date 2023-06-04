package 자바코딩인터뷰완벽가이드.배열과문자열.서러게이트페어에서코드포인트추출하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char[] musicalScore = new char[]{'\uD83C', '\uDFBC'};
        char[] smileyFace = new char[]{'\uD83D', '\uDE0D'};
        char[] twoHearts = new char[]{'\uD83D', '\uDC95'};
        char[] cyrillicZhe = new char[]{'\u04DC'};

        System.out.println(String.valueOf(musicalScore));
        System.out.println(String.valueOf(smileyFace));
        System.out.println(String.valueOf(twoHearts));
        System.out.println(String.valueOf(cyrillicZhe));

        String str = String.valueOf(Character.toChars(128149));
        System.out.println(extract2(str));
    }

    public static List<Integer> extract(String str){
        if(str == null || str.isBlank()) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            int cp = str.codePointAt(i);
            if(i < str.length() - 1 && str.codePointCount(i, i + 2) == 1){
                result.add(cp);
                result.add(str.codePointAt(i+1));
                i++;
            }
        }

        return result;
    }

    public static List<Integer> extract2(String str){
        if(str == null || str.isBlank()) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            int cp = str.codePointAt(i);
            if(Character.charCount(cp) == 2){
                result.add(cp);
                result.add(str.codePointAt(i+1));
                i++;
            }
        }

        return result;
    }
}
