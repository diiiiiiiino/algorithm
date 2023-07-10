package 코딩테스트.프로그래머스.스택큐.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];
            
            int workDay = remain / speeds[i];
            if(remain % speeds[i] > 0){
                workDay++;
            }
            
            queue.add(workDay);
        }

        int beforeDay = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        while(!queue.isEmpty()){
            int day = queue.poll();
            
            if(day > beforeDay){
                beforeDay = day;
                
                map.putIfAbsent(day, 0);
                map.put(day, map.get(day) + 1);
            } else {
                map.putIfAbsent(beforeDay, 0);
                map.put(beforeDay, map.get(beforeDay) + 1);
            }
        }
        
        return map.values()
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}