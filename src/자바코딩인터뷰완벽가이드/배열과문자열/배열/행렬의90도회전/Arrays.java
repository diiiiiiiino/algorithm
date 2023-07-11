package 자바코딩인터뷰완벽가이드.배열과문자열.배열.행렬의90도회전;

public class Arrays {
    private static void transpose(int[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = i; j < m[0].length; j++){
                int temp = m[j][i];
                m[j][i] = m[i][j];
                m[i][j] = temp;
            }
        }
    }

    private static boolean rotateWithTranspose(int[][] m){
        if(m == null || m.length == 0){
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        if(m.length != m[0].length){
            throw new IllegalArgumentException("the given matrix must be of type nxn");
        }

        transpose(m);

        for(int i = 0; i < m[0].length; i++){
            for(int j = 0, k = m[0].length - 1; j < k; j++, k--){
                int temp = m[j][i];
                m[j][i] = m[k][i];
                m[k][i] = temp;
            }
        }

        return true;
    }

    public static boolean rotateRing(int[][] m){
        if(m == null || m.length == 0){
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        if(m.length != m[0].length){
            throw new IllegalArgumentException("the given matrix must be of type nxn");
        }

        int len = m.length;

        for(int i = 0; i < len / 2; i++){
            for(int j = i; j < len - i - 1; j++){
                int temp = m[i][j];

                //오른쪽 -> 위쪽
                m[i][j] = m[j][len - 1 - i];

                //아래쪽 -> 오른쪽
                m[j][len - 1 - i] = m[len - 1 - i][len - 1 - j];

                //왼쪽 -> 아래쪽
                m[len - 1 - i][len - 1 - j] = m[len - 1 - j][i];

                //위쪽 -> 왼쪽
                m[len - 1 - j][i] = temp;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        rotateRing(new int[][]{ {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16} });
    }
}
