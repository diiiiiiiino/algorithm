package 자바코딩인터뷰완벽가이드.배열과문자열.배열.모든부분배열의고유요소;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void find(int[] m, int n){
        if(m == null){
            throw new IllegalArgumentException("The given array cannot be null");
        }

        if(n <= 0){
            throw new IllegalArgumentException("The given sub-array size cannot be <= 0");
        }

        Map<Integer, Integer> frequency = new HashMap<>();

        int countDistinct = 0;

        for(int i = 0; i < m.length; i++){
            if(i >= n){
                frequency.putIfAbsent(m[i - n], 0);
                frequency.put(m[i - n], frequency.get(m[i - n]) - 1);

                if(frequency.get(m[i - n]) == 0){
                    countDistinct--;
                }
            }

            frequency.putIfAbsent(m[i], 0);
            frequency.put(m[i], frequency.get(m[i]) + 1);

            if(frequency.get(m[i]) == 1){
                countDistinct++;
            }

            if(i >= n - 1){
                System.out.println("Distinct elements in the " + "sub-array [" + (i - n + 1) + ", " + i + "]" + " is " + countDistinct);
            }
        }
    }

    public static void main(String[] args) {
        int[] m = {7, 11, 11, -5, 13, 13, 13, 15, -4, -3, -4, 15, -2, 0, 0, 0, 14, 3, 7, 42, 3};
        int k = 5;

        System.out.println("Array: " + Arrays.toString(m));

        find(m, k);
    }
}
