package 자바코딩인터뷰완벽가이드.배열과문자열.배열.빗물모으기;

public class Bars {
    public static int trapOptimized(int[] bars){
        int left = 0;
        int right = bars.length - 1;
        int water = 0;
        int maxBarLeft = bars[left];
        int maxBarRight = bars[right];

        while(left < right){
            if(bars[left] <= bars[right]){
                left++;
                maxBarLeft = Math.max(maxBarLeft, bars[left]);
                water += (maxBarLeft - bars[left]);
            } else {
                right--;
                maxBarRight = Math.max(maxBarRight, bars[right]);
                water += (maxBarRight - bars[right]);
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] bars = {1, 0, 0, 4, 0, 2, 0, 1, 6, 2, 3};
        // int[] bars = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};  // 25
        // int[] bars = {0, 3, 0, 4, 3, 0, 3, 5, 4, 3, 4, 3}; // 10
        // int[] bars = {1, 0, 2, 2, 4, 0, 1, 5, 2, 1, 6, 1}; // 15
        // int[] bars = {0, 0, 0, 3}; // 0
        // int[] bars = {4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 14
        // int[] bars = {0, 1, 2}; // 0

        int water1 = Bars.trapOptimized(bars);
        System.out.println("Result: " + water1);
    }
}
