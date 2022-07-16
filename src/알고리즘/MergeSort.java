package 알고리즘;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        while(leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if(leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }

        while(leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint++;
        }

        while(rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint++;
        }

        return mergedList;
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }

        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = this.mergeSplitFunc(new ArrayList(dataList.subList(0, medium)));
        ArrayList<Integer> rightArr = this.mergeSplitFunc(new ArrayList(dataList.subList(medium, dataList.size())));

        return this.mergeFunc(leftArr, rightArr);
    }

    public ArrayList<Integer> mergeSplitFunc2(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }

        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = mergeSplitFunc2(new ArrayList<>(dataList.subList(0, medium)));
        ArrayList<Integer> rightArr = mergeSplitFunc2(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return this.mergeFunc2(leftArr, rightArr);
    }

    public ArrayList<Integer> mergeFunc2(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();

        int leftPoint = 0, rightPoint = 0;

        while(leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if(leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }

        while(leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint++;
        }

        while(rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        MergeSort mSort = new MergeSort();
        System.out.println(mSort.mergeSplitFunc2(testData));
    }
}
