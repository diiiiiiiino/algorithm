package 알고리즘.정렬;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int lowest;
        for(int stand = 0; stand < dataList.size() - 1; stand++) {
            lowest = stand;
            for(int index = stand + 1; index < dataList.size(); index++) {
                if(dataList.get(lowest) > dataList.get(index)) {
                    lowest = index;
                }
            }
            Collections.swap(dataList, lowest, stand);
        }
        return dataList;
    }

    public ArrayList<Integer> sort2(ArrayList<Integer> dataList) {
        int lowest;
        for(int stand = 0; stand < dataList.size() - 1; stand++) {
            lowest = stand;
            for(int index = stand + 1; index < dataList.size(); index++) {
                if(dataList.get(lowest) > dataList.get(index)) {
                    lowest = index;
                }
            }

            Collections.swap(dataList, lowest, stand);
        }

        return dataList;
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> dataList) {
        for(int stand = 0; stand < dataList.size() - 1; stand++) {
            int lowest = stand;
            for(int i = stand + 1; i < dataList.size(); i++) {
                if(dataList.get(lowest) < dataList.get(i)) {
                    lowest = i;
                }
            }

            Collections.swap(dataList, stand, lowest);
        }

        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);

        SelectionSort selectionSort = new SelectionSort();
        var results = selectionSort.sort2(list);

        System.out.println(results);

        var reverse = selectionSort.reverse(results);
        System.out.println(reverse);
    }
}
