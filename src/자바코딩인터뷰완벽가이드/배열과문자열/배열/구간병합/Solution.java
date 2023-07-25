package 자바코딩인터뷰완벽가이드.배열과문자열.배열.구간병합;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution {
    public static void mergeIntervals(Interval[] intervals){
        if(intervals == null){
            throw new IllegalArgumentException("The given array of intervals cannot be null");
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        Stack<Interval> stackOfIntervals = new Stack();

        for(Interval interval : intervals){
            if(stackOfIntervals.empty() || interval.start > stackOfIntervals.peek().end){
                stackOfIntervals.push(interval);
            }

            if(stackOfIntervals.peek().end < interval.end){
                stackOfIntervals.peek().end = interval.end;
            }
        }

        while(!stackOfIntervals.empty()){
            System.out.println(stackOfIntervals.pop() + " ");
        }
    }

    public static void mergeIntervalsOptimized(Interval[] intervals){
        if(intervals == null){
            throw new IllegalArgumentException("The given array of intervals cannot be null");
        }

        Arrays.sort(intervals, (i1, i2) -> i2.start - i1.start);

        int index = 0;

        for(int i = 0; i < intervals.length; i++){
            if(index != 0 && intervals[index - 1].start <= intervals[i].end){
                while(index != 0 && intervals[index - 1].start <= intervals[i].end){
                    intervals[index - 1].end = Math.max(intervals[index - 1].end, intervals[i].end);
                    intervals[index - 1].start = Math.min(intervals[index - 1].start, intervals[i].start);
                    index--;
                }
            } else {
                intervals[index] = intervals[i];
            }

            index++;
        }

        for(int i = 0; i < index; i++){
            System.out.println(intervals[i] + " ");
        }
    }

    public static void main(String[] args) {
        Interval intervals[] = new Interval[7];

        // [[12,15], [12,17], [2,4], [16,18], [4,7], [9,11], [1,2]]
        intervals[0] = new Interval(12, 15);
        intervals[1] = new Interval(12, 17);
        intervals[2] = new Interval(2, 4);
        intervals[3] = new Interval(16, 18);
        intervals[4] = new Interval(4, 7);
        intervals[5] = new Interval(9, 11);
        intervals[6] = new Interval(1, 2);

        System.out.print("The merged intervals via stack: ");
        //mergeIntervals(intervals);

        System.out.print("\nThe merged intervals optimized: ");
        mergeIntervalsOptimized(intervals);
    }
}
