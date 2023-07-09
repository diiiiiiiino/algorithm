package 코딩테스트.프로그래머스.완전탐색.다시풀기.카펫;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Solution {
    public int[] solution(int brown, int yellow){
        for(int width = 3; width <= 5000; width++){
            for(int height = 3; height <= width; height++){
                int boundary = (width + height - 2) * 2;
                int center = width * height - boundary;

                if(brown == boundary && yellow == center){
                    return new int[] { width, height };
                }
            }
        }

        return null;
    }
}
