package 코딩테스트.프로그래머스.구현.다시풀기.타겟넘버;

import java.util.Stack;

public class Solution {
    private static class State{
        public final int index;
        public final int acc;

        State(int index, int acc){
            this.index = index;
            this.acc = acc;
        }
    }

    public int solution(int[] numbers, int target){
        Stack<State> s = new Stack<>();
        s.push(new State(0, 0));

        int count = 0;

        while(!s.isEmpty()){
            State state = s.pop();

            if(state.index == numbers.length){
                if(state.acc == target) count++;
                continue;
            }

            s.push(new State(state.index + 1, state.acc - numbers[state.index]));
            s.push(new State(state.index + 1, state.acc + numbers[state.index]));
        }

        return count;
    }
}
