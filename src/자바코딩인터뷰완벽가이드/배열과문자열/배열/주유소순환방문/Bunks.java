package 자바코딩인터뷰완벽가이드.배열과문자열.배열.주유소순환방문;

public class Bunks {
    public static int circularTour(int[] fuel, int[] dist){
        int sumRemainingFuel = 0;
        int totalFuel = 0;
        int start = 0;

        for(int i = 0; i < fuel.length; i++){
            int remainingFuel = fuel[i] - dist[i];

            if(sumRemainingFuel >= 0){
                sumRemainingFuel += remainingFuel;
            } else {
                sumRemainingFuel = remainingFuel;
                start = i;
            }

            totalFuel += remainingFuel;
        }

        if(totalFuel >= 0){
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] dist2 = {2, 4, 1};
        int[] fuel2 = {0, 4, 3};

        int result = circularTour(fuel2, dist2);

        System.out.println(result);


        int[] dist3 = {6, 5, 3, 5};
        int[] fuel3 = {4, 6, 7, 4};

        int result2 = circularTour(fuel3, dist3);

        System.out.println(result2);

        int[] dist4 = {4, 6, 6};
        int[] fuel4 = {6, 3, 7};

        int result4 = circularTour(fuel4, dist4);

        System.out.println(result4);
    }
}
