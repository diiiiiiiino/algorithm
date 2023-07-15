package 코딩테스트.프로그래머스.동적프로그래밍.정수삼각형;

import java.util.Arrays;

class Solution2 {
    private final int[][] mem = new int[501][501];
    public int solution(int[][] triangle){
        for(int[] row : mem){
            Arrays.fill(row, -1);
        }

        return max(0, 0, triangle);
    }

    private int max(int x, int y, int[][] triangle){
        if(y == triangle.length) return 0;
        if(mem[x][y] != -1) return mem[x][y];

        return mem[x][y] = triangle[y][x] + Math.max(max(x, y + 1, triangle), max(x + 1, y + 1, triangle));
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution(new int[][]{ {7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5} });
    }
}