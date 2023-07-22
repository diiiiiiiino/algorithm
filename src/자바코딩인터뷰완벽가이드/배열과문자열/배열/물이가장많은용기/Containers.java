package 자바코딩인터뷰완벽가이드.배열과문자열.배열.물이가장많은용기;

public class Containers {
    public static int maxAreaOptimized(int[] heights){
        if(heights == null){
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int maxArea = 0;

        int i = 0;
        int j = heights.length - 1;

        while(i < j){
            maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - i));

            if(heights[i] <= heights[j]){
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
