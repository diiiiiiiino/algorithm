package 코딩테스트.프로그래머스.구현.다시풀기.스킬트리;

import java.util.Arrays;

public class Solution {
    public int solution(String skill, String[] skillTrees){
        return (int) Arrays.stream(skillTrees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }
}
