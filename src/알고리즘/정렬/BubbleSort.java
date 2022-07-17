package 알고리즘.정렬;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for(int index = 0; index < dataList.size() - 1; index++) {
            boolean swap = false;

            for(int index2 = 0; index2 < dataList.size() - 1 - index; index2++) {
                if(dataList.get(index2) > dataList.get(index2 + 1)) {
                    Collections.swap(dataList, index2, index2 + 1);
                    swap = true;
                }
            }

            if(!swap) {
                break;
            }
        }

        return dataList;
    }

    public ArrayList<Integer> sort2(ArrayList<Integer> datas) {
        for(int i = 0; i < datas.size() - 1; i++) {
            boolean swap = false;

            for(int i2 = 0; i2 < datas.size() - 1 - i; i2++) {
                if(datas.get(i2) > datas.get(i2 + 1)) {
                    Collections.swap(datas, i2, i2 + 1);
                    swap = true;
                }
            }

            if(!swap) {
                break;
            }
        }

        return datas;
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> datas){
        for(int i = 0; i < datas.size() - 1; i++) {
            boolean swap = false;
            for(int i2 = 0; i2 < datas.size() - 1 - i; i2++ ) {
                if(datas.get(i2) < datas.get(i2 + 1)) {
                    Collections.swap(datas, i2, i2 + 1);
                    swap = true;
                }
            }

            if(!swap) {
                break;
            }
        }

        return datas;
    }

    public static void main(String[] agrs) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(4);
        integers.add(3);
        integers.add(2);
        integers.add(1);

        BubbleSort bubbleSort = new BubbleSort();
        var datas = bubbleSort.sort2(integers);
        System.out.println(datas);

        datas = bubbleSort.reverse(integers);
        System.out.println(datas);
    }

}
