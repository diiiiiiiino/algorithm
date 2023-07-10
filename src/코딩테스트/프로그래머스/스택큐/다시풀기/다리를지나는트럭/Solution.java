package 코딩테스트.프로그래머스.스택큐.다시풀기.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights){
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for(int i = 0; i < bridgeLength; i++){
            bridge.add(0);
        }

        int time = 0;
        int truckIndex = 0;
        while(truckIndex < truckWeights.length){
            bridgeWeight -= bridge.poll();

            int truckWeight = truckWeights[truckIndex];
            if(bridgeWeight + truckWeight <= weight){
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIndex++;
            } else {
                bridge.add(0);
            }

            time++;
        }

        while(bridgeWeight > 0){
            bridgeWeight -= bridge.poll();
            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2, 10, new int[]{ 7, 4, 5, 6 });
    }
}
