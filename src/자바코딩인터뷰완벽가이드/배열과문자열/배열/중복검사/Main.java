package 자바코딩인터뷰완벽가이드.배열과문자열.배열.중복검사;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
    public static boolean checkDuplicates1(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkDuplicates2(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        Arrays.sort(arr);

        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == prev){
                return true;
            }

            prev = arr[i];
        }

        return false;
    }

    public static boolean checkDuplicates3(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])){
                return true;
            }

            set.add(arr[i]);
        }

        return false;
    }

    public static boolean checkDuplicates4(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        Set<Integer> set = new HashSet<>(
                Arrays.asList(IntStream.of(arr)
                        .boxed()
                        .toArray(Integer[]::new)));

        return arr.length != set.size();
    }

    public static boolean checkDuplicates5(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        Long distinctCount = IntStream.of(arr)
                .boxed()
                .distinct()
                .count();

        return arr.length != distinctCount;
    }

    /**
     * 주어진 배열에 음수가 존재하지 않은 경우
     * 각 요소는 [0, n - 1] 범위 안에 있으면 여기서 n = arr.length
     * 예외 : [1,0,0,2] 경우는 false 리턴
     * @param arr
     * @return
     */
    public static boolean checkDuplicates6(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        for(int i = 0; i < arr.length; i++){
            int index = Math.abs(arr[i]);
            if(arr[index] > 0){
                arr[index] = -arr[index];
            } else if(arr[Math.abs(arr[i])] == 0){
                arr[index] = -(arr.length - 1);
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkDuplicates6(new int[]{0,0,1,2}));
    }

}
