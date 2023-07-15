package 코딩테스트.프로그래머스.동적프로그래밍.정수삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int idx = triangle.length - 1;
        
        for(int i = idx - 1; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                int left = j, right = j + 1;
                triangle[i][j] = Math.max(triangle[i + 1][left], triangle[i + 1][right]) + triangle[i][j];
            }
        }
        
        return triangle[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{ {7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5} });
    }
}