package 코딩테스트.프로그래머스.해시.없는숫자더하기;

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        long sum = Arrays.stream(numbers)
                         .sum();
        
        return 45 - (int)sum;
    }
}