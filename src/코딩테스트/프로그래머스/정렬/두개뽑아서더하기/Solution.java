package 코딩테스트.프로그래머스.정렬.두개뽑아서더하기;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {    
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        Integer[] arr = set.toArray(new Integer[0]);
        int[] answer = new int[arr.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr[i];
        }
        
        Arrays.sort(answer);
        
        return answer;
    }

    public int[] solution2(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
}