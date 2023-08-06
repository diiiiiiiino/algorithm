package 코딩테스트.프로그래머스.구현.다시풀기.단어변환;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class Solution {
    private static class State {
        public final String word;
        public final int step;

        private State(String word, int step){
            this.word = word;
            this.step = step;
        }

        @Override
        public String toString() {
            return "State{" +
                    "word='" + word + '\'' +
                    ", step=" + step +
                    '}';
        }
    }

    private boolean isConvertable(String src,String dst){
        char[] srcArr = src.toCharArray();
        char[] dstArr = dst.toCharArray();

        int diff = 0;
        for(int i = 0; i < srcArr.length; i++){
            if(srcArr[i] != dstArr[i]) diff++;
        }

        return diff == 1;
    }

    public int solution(String begin, String target, String[] words){
        boolean[] isVisited = new boolean[words.length];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));

        while(!queue.isEmpty()){
            State state = queue.poll();

            if(state.word.equals(target)){
                return state.step;
            }

            for(int i = 0; i < words.length; i++){
                if(isVisited[i]){
                    continue;
                }

                String next = words[i];
                if(!isConvertable(state.word, next)){
                    continue;
                }

                isVisited[i] = true;
                queue.add(new State(next, state.step + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }
}
