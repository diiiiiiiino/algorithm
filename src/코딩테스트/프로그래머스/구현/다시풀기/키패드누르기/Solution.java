package 코딩테스트.프로그래머스.구현.다시풀기.키패드누르기;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    private static class Hand {
        private final int baseX;
        public final String hand;
        public final float preference;
        private int x;
        private int y;

        public Hand(String hand, boolean isPreference, int x) {
            this.baseX = x;
            this.hand = hand;
            this.preference = isPreference ? 0.5f : 0;
            this.x = x;
            this.y = 3;
        }

        public float distance(int x, int y){
            if(x == baseX) return 0;
            int distance = Math.abs(x - this.x) + Math.abs(y - this.y);
            return distance - preference;
        }

        public void move(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private int getX(int number){
        if(number == 0) return 1;
        return (number - 1) % 3;
    }

    private int getY(int number){
        if(number == 0) return 3;
        return (number - 1) / 3;
    }

    private Hand press(int number, Hand right, Hand left){
        int x = getX(number);
        int y = getY(number);

        float rDistance = right.distance(x, y);
        float lDistance = left.distance(x, y);

        Hand hand = right;
        if(lDistance < rDistance){
            hand = left;
        }

        hand.move(x, y);
        return hand;
    }

    public String solution(int[] numbers, String hand){
        Hand right = new Hand("R", hand.equals("right"), 2);
        Hand left = new Hand("L", hand.equals("left"), 0);

        return Arrays.stream(numbers)
                .mapToObj(n -> press(n, right, left).hand)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
    }
}
