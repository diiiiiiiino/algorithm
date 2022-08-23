package 알고리즘.백트래킹;

import java.util.ArrayList;

public class BackTracking {
    public boolean isAvailable(Integer currentCol, ArrayList<Integer> candidate){
        Integer currentRow = candidate.size();
        for(int row = 0; row < currentRow; row++){
            if(candidate.get(row) == currentCol || Math.abs(candidate.get(row) - currentCol) == currentRow - row){
                return false;
            }
        }

        return true;
    }

    public void func(Integer N, Integer currentRow,  ArrayList<Integer> candidate){
        if(N == currentRow){
            System.out.println(candidate);
            return;
        }

        for(int col = 0; col < N; col++){
            if(isAvailable(col, candidate)){
                candidate.add(col);
                func(N, currentRow + 1, candidate);
                candidate.remove(candidate.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        BackTracking backTracking = new BackTracking();
        backTracking.func(4, 0, new ArrayList<>());
    }
}
