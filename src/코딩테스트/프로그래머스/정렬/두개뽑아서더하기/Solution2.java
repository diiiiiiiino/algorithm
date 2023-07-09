package 코딩테스트.프로그래머스.정렬.두개뽑아서더하기;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int[] solution(int[] numbers) {
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