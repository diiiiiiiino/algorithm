package 알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
      if(dataList.size() <= 1) {
          return dataList;
      }

      int pivot = dataList.get(0);

      ArrayList<Integer> leftArr = new ArrayList<>();
      ArrayList<Integer> rightArr = new ArrayList<>();

      for(int index = 1; index < dataList.size(); index++){
          if(dataList.get(index) > pivot) {
              rightArr.add(dataList.get(index));
          } else {
              leftArr.add(dataList.get(index));
          }
      }

      ArrayList<Integer> mergedArr = new ArrayList<>();
      mergedArr.addAll(sort(leftArr));
      mergedArr.addAll(Arrays.asList(pivot));
      mergedArr.addAll(sort(rightArr));

      return mergedArr;
    }

    public ArrayList<Integer> sort2(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }

        Integer pivot = dataList.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();


        for(int index = 1; index < dataList.size(); index++) {
            if(pivot > dataList.get(index)) {
                left.add(dataList.get(index));
            } else {
                right.add(dataList.get(index));
            }
        }

        ArrayList<Integer> merged = new ArrayList<>();
        merged.addAll(sort2(left));
        merged.add(pivot);
        merged.addAll(sort2(right));

        return merged;
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }

        Integer pivot = dataList.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i = 1; i < dataList.size(); i++) {
            if(pivot < dataList.get(i)) {
                left.add(dataList.get(i));
            } else {
                right.add(dataList.get(i));
            }
        }

        ArrayList<Integer> merged = new ArrayList<>();
        merged.addAll(reverse(left));
        merged.add(pivot);
        merged.addAll(reverse(right));

        return merged;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 10; index++) {
            testData.add((int)(Math.random() * 10));
        }

        QuickSort qSort = new QuickSort();

        //System.out.println(qSort.sort(testData));
        System.out.println(qSort.sort2(new ArrayList<>(List.of(3, 6, 2, 1, 4, 5))));
        System.out.println(qSort.reverse(new ArrayList<>(List.of(3, 6, 2, 1, 4, 5))));
    }
}
