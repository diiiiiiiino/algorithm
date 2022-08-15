package 알고리즘.탐욕알고리즘;

import java.util.Arrays;

public class Greedy {

    public void knapsackFunc(Integer[][] nums, double capacity){
        Double totalValue = 0.0;
        Arrays.sort(nums, (o1, o2) -> (o2[1] / o2[0]) - (o1[1] / o1[0]));

        for(int i = 0; i < nums.length; i++) {
           if(capacity - nums[i][0] > 0) {
               capacity -= nums[i][0];
               totalValue += nums[i][1];
           } else {
               double fraction = capacity / nums[i][0];
               capacity -= nums[i][0] * fraction;
               totalValue += nums[i][1] * fraction;
               break;
           }
        }

        System.out.println("capacity : " + capacity);
        System.out.println("totalValue : " + totalValue);
    }

    public void knapsackFunc2(Integer[][] nums, double capacity){
        Arrays.sort(nums, (a, b) -> (b[1] / b[0]) - (a[1] / a[0]));

        double totalValue = 0.0;
        for(Integer[] arr : nums) {
            int weight = arr[0];
            double value = arr[1];

            if(capacity - weight > 0) {
                capacity -= weight;
                totalValue += value;
                System.out.println("value : " + value + " weight : " + weight);
            } else {
                double fraction = capacity / weight;
                capacity -= weight * fraction;
                totalValue += value * fraction;
                System.out.println("value : " + value + " weight : " + weight + " value * fraction " + value * fraction);
            }
        }
        System.out.println("totalValue : " + totalValue);
    }


    public static void main(String[] args){
        Greedy gObject = new Greedy();
        Integer[][] nums = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.knapsackFunc2(nums, 30.0);
    }

}
