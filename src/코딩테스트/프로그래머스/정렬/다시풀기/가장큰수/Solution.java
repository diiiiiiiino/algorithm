package 코딩테스트.프로그래머스.정렬.다시풀기.가장큰수;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String str = Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);

                    return reversed - original;
                })
                .collect(Collectors.joining())
                .replaceAll("^0+", "0");

        return str;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{0, 0, 0, 0});
    }
}