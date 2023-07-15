package 자바코딩인터뷰완벽가이드.배열과문자열.배열.정렬된배열병합;

public class MinHeap {
    int data;
    int heapIndex;
    int currentIndex;

    public MinHeap(int data, int heapIndex, int currentIndex) {
        this.data = data;
        this.heapIndex = heapIndex;
        this.currentIndex = currentIndex;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}
