package 알고리즘;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int index = 0; index < dataList.size() - 1; index++) {
            for(int index2 = index + 1; index2 > 0; index2--) {
                if(dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }

    public ArrayList<Integer> sort2(ArrayList<Integer> dataList) {
        for(int index = 0; index < dataList.size() - 1; index++) {
            for(int index2 = index + 1; index2 > 0; index2-- ) {
                if(dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> dataList) {
       for(int i = 0; i < dataList.size() - 1; i++) {
           for(int i2 = i + 1; i2 > 0; i2--) {
               if(dataList.get(i2) > dataList.get(i2 - 1)) {
                   Collections.swap(dataList, i2, i2 - 1);
               } else {
                   break;
               }
           }
       }

       return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 10));
        }

        InsertionSort insertionSort = new InsertionSort();
        var result = insertionSort.sort2(list);
        System.out.println(result);

        var reverse = insertionSort.reverse(result);
        System.out.println(reverse);
    }
}
