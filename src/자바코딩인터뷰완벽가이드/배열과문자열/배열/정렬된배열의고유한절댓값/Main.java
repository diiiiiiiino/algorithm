package 자바코딩인터뷰완벽가이드.배열과문자열.배열.정렬된배열의고유한절댓값;

import java.util.Arrays;

public class Main {
    public static int findAbsoluteDistinct(int[] m){
        if(m == null){
            return -1;
        }

        int count = m.length;

        int left = 0;
        int right = m.length - 1;

        while(left < right){
            while(left < right && m[left] == m[left + 1]){
                count--;
                left++;
            }

            while(right > left && m[right] == m[right - 1]){
                count--;
                right--;
            }

            if(left == right){
                break;
            }

            int sum = m[left] + m[right];

            if(sum == 0){
                count--;

                left++;
                right--;
            } else if(sum < 0){
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] m = {-3, -3, -2, -1, -1, -1, 0, 1, 1, 1, 2, 2, 3, 5, 6, 7, 7};

        int result = findAbsoluteDistinct(m);

        System.out.println("Array: " + Arrays.toString(m));
        System.out.print("The number of distinct absolute values is: " + result);
    }
}
