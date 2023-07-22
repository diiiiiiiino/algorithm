package 자바코딩인터뷰완벽가이드.배열과문자열.배열.물이가장많은용기;

public class Main {
    public static void main(String[] args) {
        int[] heights = {1, 4, 6, 2, 7, 3, 8, 5, 3};

        int max = Containers.maxAreaOptimized(heights);

        System.out.println("Result: " + max);
    }
}