package 코딩테스트.프로그래머스.해시.중복된문자제거;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public String solution(String myString){
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