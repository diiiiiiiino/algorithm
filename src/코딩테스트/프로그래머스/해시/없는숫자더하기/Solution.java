package 코딩테스트.프로그래머스.해시.없는숫자더하기;

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        long sum = Arrays.stream(numbers)
                         .sum();
        
        return 45 - (int)sum;
    }

    public int solution2(int[] numbers){
        Set<Integer> set = new HashSet<>();
        for(int v : numbers){
            set.add(v);
        }

        int sum = 0;
        for(int n = 0; n <= 9; n++){
            if(set.contains(n)) continue;
            sum += n;
        }

        return sum;
    }
}