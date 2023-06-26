package 코딩테스트.프로그래머스.정렬.문자열내림차순으로배치하기;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strs = s.split("");
        
        Arrays.sort(strs, (s1, s2) -> s2.compareTo(s1));
        
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }
        
        
        return sb.toString();
    }
}