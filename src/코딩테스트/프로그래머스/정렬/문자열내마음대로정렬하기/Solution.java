package 코딩테스트.프로그래머스.정렬.문자열내마음대로정렬하기;

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            String word1 = s1.substring(n, n + 1);
            String word2 = s2.substring(n, n + 1);
            
            if(!word1.equals(word2)){
                return word1.compareTo(word2);
            }
            
            return s1.compareTo(s2);
        });
        
        return strings;
    }

    public String[] solution2(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) != s2.charAt(n)){
                return s1.charAt(n) - s2.charAt(n);
            }

            return s1.compareTo(s2);
        });

        return strings;
    }
}