package 코딩테스트.프로그래머스.정렬.문자열내림차순으로배치하기;

import java.util.Arrays;

class Solution2 {
    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution("gfedcbZ");
    }
}