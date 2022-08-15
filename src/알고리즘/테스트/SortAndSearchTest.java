package 알고리즘.테스트;

import 알고리즘.정렬.MergeSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortAndSearchTest {
    public void bubbleSort(ArrayList<Integer> dataList) {
        for(int i = 0; i < dataList.size() - 1; i++) {
            boolean swap = false;
            for(int j = 0; j < dataList.size() - 1 - i; j++) {
                if(dataList.get(j) > dataList.get(j + 1)){
                    Collections.swap(dataList, j, j+1);
                    swap = true;
                }
            }

            if(!swap) {
                break;
            }
        }
    }

    public void insertionSort(ArrayList<Integer> dataList) {
        for(int i = 0; i < dataList.size() - 1; i++) {
            for(int j = i + 1; j > 0; j--) {
                if(dataList.get(j - 1) > dataList.get(j)) {
                    Collections.swap(dataList, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public void selectionSort(ArrayList<Integer> dataList) {
        for(int i = 0; i < dataList.size() - 1; i++) {
            int lowest = i;
            for(int j = i + 1; j < dataList.size(); j++) {
                if(dataList.get(lowest) > dataList.get(j)) {
                    lowest = j;
                }
            }
            Collections.swap(dataList, lowest, i);
        }
    }

    public List<Integer> mergeSort(List<Integer> dataList){
        if(dataList.size() <= 1) {
            return dataList;
        }

        int mid = dataList.size() / 2;

        List<Integer> leftList = mergeSort(dataList.subList(0, mid));
        List<Integer> rightList = mergeSort(dataList.subList(mid, dataList.size()));

        return merge(leftList, rightList);
    }

    public List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> mergedList = new ArrayList<>();
        int leftPointer = 0, rightPointer = 0;
        while(leftList.size() > leftPointer && rightList.size() > rightPointer) {
            if(leftList.get(leftPointer) > rightList.get(rightPointer)) {
                mergedList.add(rightList.get(rightPointer));
                rightPointer++;
            } else {
                mergedList.add(leftList.get(leftPointer));
                leftPointer++;
            }
        }

        while(leftList.size() > leftPointer){
            mergedList.add(leftList.get(leftPointer));
            leftPointer++;
        }

        while(rightList.size() > rightPointer) {
            mergedList.add(rightList.get(rightPointer));
            rightPointer++;
        }

        return mergedList;
    }

    public List<Integer> quickSort(List<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }

        int pivot = dataList.get(0);
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for(int val : dataList) {
            if(pivot > val) {
                leftList.add(val);
            } else {
                rightList.add(val);
            }
        }

        List<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(quickSort(leftList));
        mergedList.add(pivot);
        mergedList.addAll(quickSort(rightList));

        return mergedList;
    }

    public boolean binarySearch(List<Integer> dataList, int searchData) {
        Collections.sort(dataList);

        if(dataList.size() == 0) {
            return false;
        }
        if(dataList.size() == 1 && dataList.get(0) == searchData) {
            return true;
        }
        if(dataList.size() == 1 && dataList.get(0) != searchData) {
            return false;
        }

        int mid = dataList.size() / 2;

        if(dataList.get(mid) == searchData) {
            return true;
        } else {
            if(dataList.get(mid) > searchData) {
                return binarySearch(dataList.subList(0, mid), searchData);
            } else {
                return binarySearch(dataList.subList(mid + 1, dataList.size()), searchData);
            }
        }
    }

    public boolean sequentialSearch(List<Integer> dataList, int searchData) {
        for(int val : dataList) {
            if(val == searchData) {
                return true;
            }
        }

        return false;
    }

    public int dynamic(int data) {
        int[] arr = new int[data+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[data];
    }

    public int recurcive(int data) {
        if(data <= 1) {
            return data;
        }

        return recurcive(data - 2) + recurcive(data - 1);
    }
}
