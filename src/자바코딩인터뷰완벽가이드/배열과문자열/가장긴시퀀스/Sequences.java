package 자바코딩인터뷰완벽가이드.배열과문자열.가장긴시퀀스;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sequences {
    public static int findLongestConsecutive(int[] sequence){
        if(sequence == null){
            throw new IllegalArgumentException("The given sequence cannot be empty");
        }

        Set<Integer> sequenceSet = IntStream.of(sequence)
                .boxed()
                .collect(Collectors.toSet());

        int longestSequence = 1;

        for(int elem : sequence){
            if(!sequenceSet.contains(elem - 1)){
                int sequenceLength = 1;

                while(sequenceSet.contains(elem + sequenceLength)){
                    sequenceLength++;
                }

                longestSequence = Math.max(longestSequence, sequenceLength);
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        int[] sequence1 = {4, 2, 9, 5, 12, 6, 8};
        int[] sequence2 = {2, 0, 6, 1, 4, 3, 8};

        int longestSequence1 = Sequences.findLongestConsecutive(sequence1);
        System.out.println("Longest sequence has " + longestSequence1 + " element(s)");

        int longestSequence2 = Sequences.findLongestConsecutive(sequence2);
        System.out.println("Longest sequence has " + longestSequence2 + " element(s)");
    }
}
