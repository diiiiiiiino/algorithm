package 코딩테스트.프로그래머스.해시.다시풀기.완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] participant, String[] completion){
        Map<String, Integer> count = new HashMap<>();

        for(String name : participant){
            count.putIfAbsent(name, 0);
            count.put(name, count.get(name) + 1);
        }

        for(String name : completion){
            int v = count.get(name) - 1;
            count.put(name, v);
            if(v == 0) count.remove(name);
        }

        return count.keySet().iterator().next();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
    }
}
