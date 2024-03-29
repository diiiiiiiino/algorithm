package 코딩테스트.프로그래머스.정렬.다시풀기.H인덱스;

import java.util.Arrays;

public class Solution {
    private boolean isValid(int[] citations, int h){
        int index = citations.length - h;
        return citations[index] >= h;
    }

    public int solution(int[] citations){
        Arrays.sort(citations);
        for(int h = citations.length; h >= 1; h--){
            if(isValid(citations, h)) return h;
        }

        return 0;
    }
}
