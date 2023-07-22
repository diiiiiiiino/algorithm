package 자바코딩인터뷰완벽가이드.배열과문자열.배열.모든요소가1인부분행렬;

public class Matrices {
    public static int ofOneOptimized(int[][] matrix){
        if(matrix == null){
            throw new IllegalArgumentException("The given matrix cannot be null");
        }

        int maxSubMatrixSize = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] subMatrix = new int[rows][cols];

        for(int i = 0; i < cols; i++){
            subMatrix[0][i] = matrix[0][i];
        }

        for(int i = 0; i < rows; i++){
            subMatrix[i][0] = matrix[i][0];
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[i][j] == 1){
                    subMatrix[i][j] = Math.min(subMatrix[i-1][j-1], Math.min(subMatrix[i][j-1], subMatrix[i-1][j])) + 1;

                    maxSubMatrixSize = Math.max(maxSubMatrixSize, subMatrix[i][j]);
                }
            }
        }

        return maxSubMatrixSize;
    }
}
