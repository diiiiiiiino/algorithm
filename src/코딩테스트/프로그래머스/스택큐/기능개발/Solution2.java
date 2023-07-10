package 코딩테스트.프로그래머스.스택큐.기능개발;

import java.util.*;

class Solution2 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            q.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        while(!q.isEmpty()){
            int index = q.poll();
            int expiration = (int) Math.ceil((double) (100 - progresses[index]) / speeds[index]);
            if(expiration > days){
                if(days != 0){
                    result.add(count);
                    count = 0;
                }
            }
            count++;
        }

        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}