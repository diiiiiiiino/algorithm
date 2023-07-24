package 자바코딩인터뷰완벽가이드.배열과문자열.배열.원형정렬배열에서검색;

public class Main {
    public static void main(String[] args) {
        //int[] m = {11, 14, 23, 24, -1, 3, 5, 6, 8, 9, 10};
        //int x = 14;
        int[] m = {5,6,7,8,9,1,2,3,4};
        int x = 4;

        int foundIndex = Arrays.find(m, x);

        System.out.println("Array: " + java.util.Arrays.toString(m));
        System.out.println("The value " + x + " was found at index " + foundIndex);
    }
}