package 코딩테스트.프로그래머스.완전탐색.모의고사;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    private final int[][] RULES = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

    private int getPicked(int person, int problem){
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }

    public int[] solution2(int[] answers){
        int[] corrects = new int[3];
        int max = 0;

        for(int problem = 0; problem < answers.length; problem++){
            int answer = answers[problem];

            for(int person = 0; person < 3; person++){
                int picked = getPicked(person, problem);
                if(answer == picked){
                    if(++corrects[person] > max){
                        max = corrects[person];
                    }
                }
            }
        }

        final int maxCorrects = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();
    }


    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int max = Integer.MIN_VALUE;
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < RULES.length; i++){
            int[] rule = RULES[i];
            
            int count = 0;
            for(int problem = 0; problem < answers.length; problem++){
                if(answers[problem] == rule[problem % rule.length]){
                    count++;
                }
            }
            
            if(max < count){
                max = count;
                arr.clear();
                arr.add(i + 1);
            } else if(max == count){
                arr.add(i + 1);
            }
        }
        
        answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }
}