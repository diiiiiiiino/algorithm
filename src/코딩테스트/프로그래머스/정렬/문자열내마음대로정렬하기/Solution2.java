package 코딩테스트.프로그래머스.정렬.문자열내마음대로정렬하기;

import java.util.Arrays;

class Solution2 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) != s2.charAt(n)){
                return s1.charAt(n) - s2.charAt(n);
            }

            return s1.compareTo(s2);
        });

        return strings;
    }
}