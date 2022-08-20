package 알고리즘.탐욕알고리즘;

import java.util.Arrays;

public class Greedy {
    public void func(Integer[][] objectList, double maxWeight){
        Arrays.sort(objectList, (o1, o2) -> (o2[1] / o2[0]) - (o1[1] / o1[0]));

        double totalValue = 0.0;
        for(Integer[] item : objectList) {
            Integer weight = item[0];
            Integer value = item[1];

            if(maxWeight - weight > 0) {
                maxWeight -= weight;
                totalValue += value;
                System.out.println("무게 : " + weight + ", 가치 " + value);
            } else {
                double ratio = maxWeight / weight;
                maxWeight -= weight * ratio;
                totalValue += value * ratio;
                System.out.println("무게 : " + weight + ", 가치 " + value + ", 비율 " + ratio );
                break;
            }
        }

        System.out.println("총 담을 수 있는 가치 : " + totalValue);
    }

    public static void main(String[] args){
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        Greedy greedy = new Greedy();
        greedy.func(objectList, 25);
    }

}
