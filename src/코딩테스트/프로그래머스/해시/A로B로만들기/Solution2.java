package 코딩테스트.프로그래머스.해시.A로B로만들기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int solution(String before, String after){
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