package 자바코딩인터뷰완벽가이드.배열과문자열.배열.ZERO를포함하는행렬;

public class Arrays {
    public static void alignZeros(int[][] m){
        if(m == null || m.length == 0){
            throw new IllegalArgumentException();
        }

        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for(int j = 0; j < m[0].length; j++){
            if(m[0][j] == 0){
                firstRowHasZero = true;
                break;
            }
        }

        for(int i = 0; i < m.length; i++){
            if(m[i][0] == 0){
                firstColumnHasZero = true;
                break;
            }
        }

        for(int i = 1; i < m.length; i++){
            for(int j = 1; j < m[0].length; j++){
                if(m[i][j] == 0){
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m.length; i++){
            if(m[i][0] == 0){
                setRowsOfZero(m, i);
            }
        }

        for(int j = 1; j < m[0].length; j++){
            if(m[0][j] == 0){
                setColumnOfZero(m, j);
            }
        }

        if(firstRowHasZero){
            setRowsOfZero(m, 0);
        }

        if(firstColumnHasZero){
            setColumnOfZero(m, 0);
        }
    }

    private static void setRowsOfZero(int[][] m, int i) {
        for(int j = 0; j < m[0].length; j++){
            m[i][j] = 0;
        }
    }

    private static void setColumnOfZero(int[][] m, int j) {
        for(int i = 0; i < m.length; i++){
            m[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        alignZeros(new int[][]{ {1,2,3,4}, {1,2,3,4}, {1,0,3,4}, {1,2,3,4} });
    }
}
