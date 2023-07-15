package 자바코딩인터뷰완벽가이드.배열과문자열.배열.쌍;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int sum = 10;
        int[] arr = new int[]{-5, -2, 5, 4, 3, 7, 2, 1, -1, -2, 15, 6, 12, -4, 3};

        List<String> result = Arrays.pairs(arr, sum);

        System.out.println("Result: " + result);
    }
}