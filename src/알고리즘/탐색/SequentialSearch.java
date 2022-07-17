package 알고리즘.탐색;

import java.util.ArrayList;
import java.util.Arrays;

public class SequentialSearch {

    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for(int i = 0; i < dataList.size(); i++) {
            if(dataList.get(i) == searchItem) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SequentialSearch sequentialSearch = new SequentialSearch();
        Integer searchIdx = sequentialSearch.searchFunc(new ArrayList<>(Arrays.asList(5, 3, 7, 6, 4)), 3);

        System.out.println(searchIdx);
    }
}
