package 자바코딩인터뷰완벽가이드.배열과문자열.배열.요소를순위로변환;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void replace(int[] m){
        if(m == null){
            throw new IllegalArgumentException("The given array cannot be null");
        }

        Map<Integer, Integer> treemap = new TreeMap<>();

        for(int i = 0; i < m.length; i++){
            treemap.put(m[i], i);
        }

        int rank = 1;

        for(Map.Entry<Integer, Integer> entry : treemap.entrySet()){
            m[entry.getValue()] = rank++;
        }
    }

    public static void main(String[] args) {
        // 중복 요소는 허용하지 않습니다.
        int[] m = {7, 11, -5, 13, 15, -4, -3, -2, 0, 14, 3, 42};

        System.out.println("Before: " + Arrays.toString(m));

        replace(m);

        System.out.println("After: " + Arrays.toString(m));
    }
}
