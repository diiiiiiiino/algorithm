package 자바코딩인터뷰완벽가이드.연결리스트와맵.너트와볼트;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        char[] nuts = {'$', '%', '&', 'x', '+'};
        char[] bolts = {'%', '@', 'x', '$', '&'};

        match(nuts, bolts);
    }

    public static void match(char[] nuts, char[] bolts){
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < nuts.length; i++){
            map.put(nuts[i], i);
        }

        for(int i = 0; i < nuts.length; i++){
            char bolt = bolts[i];

            if(map.containsKey(bolt)){
                nuts[i] = bolts[i];
            } else {
                System.out.println("Bolt " + bolt + " has no nut");
            }
        }

        System.out.println("Match between nuts and bolts : ");
        System.out.println("Nuts: " + Arrays.toString(nuts));
        System.out.println("Bolts: " + Arrays.toString(bolts));
    }
}
