package 자료구조;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data){
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean moveUp(Integer insertedIdx) {
        if(insertedIdx <= 1) {
            return false;
        }

        Integer parentIdx = insertedIdx / 2;
        if(this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(Integer data) {
        Integer insertedIdx, parentIdx;

        if(heapArray == null) {
            heapArray = new ArrayList<>();

            heapArray.add(null);
            heapArray.add(data);

            return true;
        }

        this.heapArray.add(data);
        insertedIdx = this.heapArray.size() - 1;

        while(moveUp(insertedIdx)){
            parentIdx = insertedIdx / 2;
            Collections.swap(this.heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
        return true;
    }

    public boolean moveDown(Integer idx) {
        Integer leftIdx, rightIdx;

        leftIdx = idx * 2;
        rightIdx = idx * 2 + 1;

        if(leftIdx >= this.heapArray.size()) {
            return false;
        } else if(rightIdx >= this.heapArray.size()) {
            if(this.heapArray.get(idx) < this.heapArray.get(leftIdx)) {
                return true;
            } else {
                return false;
            }
        } else {
            if(this.heapArray.get(leftIdx) > this.heapArray.get(rightIdx)) {
                if(this.heapArray.get(idx) < this.heapArray.get(leftIdx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if(this.heapArray.get(idx) < this.heapArray.get(rightIdx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public Integer pop() {
        Integer returnData, idx, leftIdx, rightIdx;

        if(this.heapArray == null) {
            return null;
        } else {
            returnData = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);
            idx = 1;

            while(moveDown(idx)) {
                leftIdx = idx * 2;
                rightIdx = idx * 2 + 1;

                if(rightIdx >= this.heapArray.size()) {
                    if(this.heapArray.get(idx) < this.heapArray.get(leftIdx)) {
                        Collections.swap(this.heapArray, idx, leftIdx);
                        idx = leftIdx;
                    }
                } else {
                    if(this.heapArray.get(leftIdx) > this.heapArray.get(rightIdx)) {
                        if(this.heapArray.get(idx) < this.heapArray.get(leftIdx)) {
                            Collections.swap(this.heapArray, idx, leftIdx);
                            idx = leftIdx;
                        }
                    } else {
                        if(this.heapArray.get(idx) < this.heapArray.get(rightIdx)) {
                            Collections.swap(this.heapArray, idx, rightIdx);
                            idx = rightIdx;
                        }
                    }
                }
            }
            return returnData;
        }
    }
}
