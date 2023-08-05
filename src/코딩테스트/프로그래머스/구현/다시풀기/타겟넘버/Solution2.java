package 코딩테스트.프로그래머스.구현.다시풀기.타겟넘버;

public class Solution2 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    private int dfs(int[] numbers, int idx, int currentSum, int target) {
        if (idx == numbers.length) {
            if (currentSum == target) {
                return 1;
            }
            return 0;
        }

        int result = 0;
        result += dfs(numbers, idx + 1, currentSum + numbers[idx], target);
        result += dfs(numbers, idx + 1, currentSum - numbers[idx], target);

        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(new int[]{1, 1}, 0));
    }
}
