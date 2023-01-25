package 코딩테스트.완전탐색;

/**
 * https://www.acmicpc.net/problem/14888
 */
public class BOJ14888 {

    static int N = 6;
    static int[] nums = new int[N + 1];
    static int[] operators = new int[4];
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2){
        int result = 0;
        switch (operator){
            case 0:
                result = operand1 + operand2;
                break;
            case 1:
                result = operand1 - operand2;
                break;
            case 2:
                result = operand1 * operand2;
                break;
            case 3:
                result = operand1 / operand2;
                break;
        }

        return result;
    }

    public static void func(int k, int value){
        if(k == N){
            if(min > value){
                min = value;
            }

            if(max < value){
                max = value;
            }
        } else {
            for(int i = 0; i < 4; i++){
                if(operators[i] == 0){
                    continue;
                }
                operators[i]--;
                func(k + 1, calculator(value, i, nums[k + 1]));
                operators[i]++;
            }
        }
    }

    public static void main(String[] args){

        for(int i = 1; i <= N; i++){
            nums[i] = i;
        }

        operators[0] = 2;
        operators[1] = 1;
        operators[2] = 1;
        operators[3] = 1;

        func(1, nums[1]);
        System.out.println(max);
        System.out.println(min);
    }
}