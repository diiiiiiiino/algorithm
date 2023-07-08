package 코딩테스트.프로그래머스.해시.A로B로만들기;

import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] beforeChars = before.toCharArray();
        char[] afterChars = after.toCharArray();
        
        Arrays.sort(beforeChars);
        Arrays.sort(afterChars);
        
        for(int i = 0; i < beforeChars.length; i++){
            if(beforeChars[i] != afterChars[i]){
                return 0;
            }
        }
        
        
        return 1;
    }

    public int solution2(String before, String after){
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }

    private static Map<Character, Integer> toMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : word.toCharArray()){
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        return map;
    }


}