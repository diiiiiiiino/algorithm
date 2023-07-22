package 자바코딩인터뷰완벽가이드.배열과문자열.배열.모든요소가1인부분행렬;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 1, 1, 0, 0, 0}, 
            {1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0},
        };

        // int max = Matrices.ofOne(matrix);
        int max = Matrices.ofOneOptimized(matrix);
        System.out.println("\n\nMax: " + max);
    }
}