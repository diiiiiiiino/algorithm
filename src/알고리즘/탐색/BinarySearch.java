package 알고리즘.탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public boolean searchFunc(List<Integer> dataList, Integer searchItem) {
        if(dataList.size() == 1 && dataList.get(0) == searchItem) {
            return true;
        }
        if(dataList.size() == 1 && dataList.get(0) != searchItem) {
            return false;
        }
        if(dataList.size() == 0) {
            return false;
        }

        Integer mid = dataList.size() / 2;

        if(dataList.get(mid) == searchItem) {
            return true;
        } else {
            if(dataList.get(mid) > searchItem) {
                return searchFunc(dataList.subList(0, mid), searchItem);
            } else {
                return searchFunc(dataList.subList(mid + 1, dataList.size()), searchItem);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>(List.of(1,3,5,4,6));
        Collections.sort(dataList); //이진탐색은 정렬된 상태에서 해야한다.

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.searchFunc(dataList, 6));
    }
}
