package 코딩테스트.프로그래머스.해시.중복된문자제거;

import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        String[] strs = my_string.split("");
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : strs){
            String str = sb.toString();
            if(str.contains(s)) continue;
            
            sb.append(s);
        }
        
        
        return sb.toString();
    }

    public String solution2(String myString){
        Set<Character> used = new HashSet<>();

        StringBuilder builder = new StringBuilder();
        for(char c : myString.toCharArray()){
            if(used.contains(c)) continue;
            used.add(c);
            builder.append(c);
        }

        return builder.toString();
    }
}