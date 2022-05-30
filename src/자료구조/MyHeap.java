package 자료구조;

import java.util.ArrayList;
import java.util.Collections;

public class MyHeap implements IHeap{

    public ArrayList<Integer> heapArr = new ArrayList<>();

    public MyHeap(Integer data) {
        this.heapArr.add(null);
        this.heapArr.add(data);
    }

    @Override
    public boolean insert(Integer data) {
        if(this.heapArr.size() == 0) {
            this.heapArr.add(null);
            this.heapArr.add(data);
        } else {
            this.heapArr.add(data);
            Integer insertedIdx = this.heapArr.size() - 1;

            while(moveUp(insertedIdx)) {
                Integer parentIdx = insertedIdx / 2;
                Collections.swap(this.heapArr, insertedIdx, parentIdx);
                insertedIdx = parentIdx;
            }
        }

        return true;
    }

    @Override
    public Integer pop() {
        if(this.heapArr.size() == 0) {
            return null;
        } else {
            Integer resultData = this.heapArr.get(1);
            int lastIdx = this.heapArr.size() - 1;
            this.heapArr.set(1, this.heapArr.get(lastIdx));
            this.heapArr.remove(lastIdx);

            int currentIdx = 1;
            while(moveDown(currentIdx)) {
                Integer leftIdx = currentIdx * 2;
                Integer rightIdx = currentIdx * 2 + 1;

                if(rightIdx >= this.heapArr.size()) {
                    if(this.heapArr.get(currentIdx) < this.heapArr.get(leftIdx)) {
                        Collections.swap(this.heapArr, currentIdx, leftIdx);
                        currentIdx = leftIdx;
                    }
                } else {
                    if(this.heapArr.get(leftIdx) > this.heapArr.get(rightIdx)) {
                        if(this.heapArr.get(currentIdx) < this.heapArr.get(leftIdx)) {
                            Collections.swap(this.heapArr, currentIdx, leftIdx);
                            currentIdx = leftIdx;
                        }
                    } else {
                        if(this.heapArr.get(currentIdx) < this.heapArr.get(rightIdx)) {
                            Collections.swap(this.heapArr, currentIdx, rightIdx);
                            currentIdx = rightIdx;
                        }
                    }
                }
            }

            return resultData;
        }
    }

    @Override
    public boolean moveUp(Integer insertedIdx) {
        if(insertedIdx <= 1) {
            return false;
        }

        Integer parentIdx = insertedIdx / 2;
        if(this.heapArr.get(insertedIdx) > this.heapArr.get(parentIdx)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean moveDown(Integer poppedIdx) {
        Integer leftIdx = poppedIdx * 2;
        Integer rightIdx = poppedIdx * 2 + 1;

        if(leftIdx >= this.heapArr.size()) {
            return false;
        } else if(rightIdx >= this.heapArr.size()) {
            if(this.heapArr.get(poppedIdx) < this.heapArr.get(leftIdx)) {
                return true;
            } else {
                return false;
            }
        } else {
            if(this.heapArr.get(leftIdx) > this.heapArr.get(rightIdx)) {
                if(this.heapArr.get(poppedIdx) < this.heapArr.get(leftIdx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if(this.heapArr.get(poppedIdx) < this.heapArr.get(rightIdx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
