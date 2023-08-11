package 자바코딩인터뷰완벽가이드.배열과문자열.배열.배열k번회전;

import java.util.Arrays;

public class Main {
    public static void rightRotate(int[] m, int k){
        int[] cm = m.clone();
        int len = m.length;

        for(int i = 0; i < len; i++){
            m[(i + k) % len] = cm[i];
        }
    }

    public static void main(String[] args) {
        int A1[] = {1, 2, 3, 4, 5};
        int k1 = 3;

        int A2[] = {5, 5, 2, 3, 1, -2, 33, -1};
        int k2 = 5;

        System.out.println("Before: " + Arrays.toString(A1));
        rightRotate(A1, k1);
        System.out.println("After: " + Arrays.toString(A1));

        System.out.println("Before: " + Arrays.toString(A2));
        rightRotate(A2, k2);
        System.out.println("After: " + Arrays.toString(A2));
    }
}
