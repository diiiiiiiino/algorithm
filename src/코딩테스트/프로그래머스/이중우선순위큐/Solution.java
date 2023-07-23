package 코딩테스트.프로그래머스.이중우선순위큐;

import java.util.*;

class Solution {
    private class DoublePriorityQueue{
        PriorityQueue<Integer> minQueue;
        PriorityQueue<Integer> maxQueue;
        int cnt;
        
        DoublePriorityQueue(){
            minQueue = new PriorityQueue<>();
            maxQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
            cnt = 0;
        }
        
        public void add(int value){
            minQueue.add(value);
            maxQueue.add(value);
            cnt++;
        }
        
        public int minPoll(){
            if(minQueue.isEmpty()){
                return 0;
            }
            int value = minQueue.poll();
            cnt--;
            clear();
            
            return value;
        }
        
        public int maxPoll(){
            if(maxQueue.isEmpty()){
                return 0;
            }
            int value = maxQueue.poll();
            
            cnt--;
            clear();
            
            return value;
        }
        
        private void clear(){
            if(cnt == 0){
                minQueue.clear();
                maxQueue.clear();
            }
        }
    }
    
    public int[] solution(String[] operations) {    
        DoublePriorityQueue dpq = new DoublePriorityQueue();
        
        int min = 0, max = 0;
        for(int i = 0; i < operations.length; i++){
            String[] strs = operations[i].split(" ");
            String op = strs[0];
            String num = strs[1];
            
            switch(op){
                case "I":
                    dpq.add(Integer.parseInt(num));
                    break;
                case "D":
                    if("1".equals(num)){
                        dpq.maxPoll();
                    } else if("-1".equals(num)){
                        dpq.minPoll();
                    }
                    break;
            }
        }

        max = dpq.maxPoll();
        min = dpq.minPoll();

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
    }
}