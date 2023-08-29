package 자바코딩인터뷰완벽가이드.트리와그래프.최대힙을최소힙으로변환;

import java.util.Arrays;

public class Heaps {
    public static void convertToMinHeap(int[] maxHeap){
        if(maxHeap == null){
            throw new IllegalArgumentException();
        }

        int p = (maxHeap.length - 2) / 2;
        while(p >= 0){
            heapifyMin(maxHeap, p--, maxHeap.length);
        }
    }

    private static void heapifyMin(int[] maxHeap, int p, int size) {
        int left = leftChild(p);
        int right = rightChild(p);

        int smallest = p;

        if((left < size) && (maxHeap[left] < maxHeap[p])){
            smallest = left;
        }

        if((right < size) && (maxHeap[right] < maxHeap[smallest])){
            smallest = right;
        }

        if(smallest != p){
            swap(maxHeap, p, smallest);
            heapifyMin(maxHeap, smallest, size);
        }
    }

    public static void convertToMaxHeap(int[] minHeap) {
        if (minHeap == null) {
            throw new IllegalArgumentException("The given min heap cannot be null");
        }

        int p = (minHeap.length - 2) / 2;
        while (p >= 0) {
            heapifyMax(minHeap, p--, minHeap.length);
        }
    }

    private static void heapifyMax(int[] minHeap, int p, int size) {
        int left = leftChild(p);
        int right = rightChild(p);

        int largest = p;

        if ((left < size) && (minHeap[left] > minHeap[p])) {
            largest = left;
        }

        if ((right < size) && (minHeap[right] > minHeap[largest])) {
            largest = right;
        }

        if (largest != p) {
            swap(minHeap, p, largest);
            heapifyMax(minHeap, largest, size);
        }
    }

    private static int leftChild(int parentIndex){
        return (2 * parentIndex + 1);
    }

    private static int rightChild(int parentIndex){
        return (2 * parentIndex + 2);
    }

    private static void swap(int heap[], int i, int j){
        int aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    public static void main(String[] args) {
        /*
              40
            /    \
          37      25
         /  \    /  \
        33  34  20   22
        */

        // 최대 힙(heap)
        int arrMaxHeap[] = {40, 37, 25, 33, 34, 20, 22};
        int arrMinHeap[] = {20, 33, 22, 37, 34, 25, 40};

        System.out.println("Max heap: " + Arrays.toString(arrMaxHeap));
        Heaps.convertToMinHeap(arrMaxHeap);
        System.out.println("Min heap: " + Arrays.toString(arrMaxHeap));

        System.out.println("\n\nMin heap: " + Arrays.toString(arrMinHeap));
        Heaps.convertToMaxHeap(arrMinHeap);
        System.out.println("Max heap: " + Arrays.toString(arrMinHeap));
    }
}
