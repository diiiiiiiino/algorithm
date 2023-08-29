package 자바코딩인터뷰완벽가이드.트리와그래프.최소비용으로n개의밧줄연결하기;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
    private static final int DEFAULT_CAPACITY = 5;

    private int capacity;
    private int size;
    private int[] heap;

    public MinHeap() {
        capacity = DEFAULT_CAPACITY;
        this.heap = new int[DEFAULT_CAPACITY];
    }

    public int minimumCost(int[] ropeLength) {
        if (ropeLength == null) {
            return -1;
        }

        // 밧줄의 길이를 힙에 삽입합니다.
        for (int i = 0; i < ropeLength.length; i++) {
            add(ropeLength[i]);
        }

        int totalLength = 0;

        while (size() > 1) {
            int l1 = poll();
            int l2 = poll();

            totalLength += (l1 + l2);

            add(l1 + l2);
        }

        return totalLength;
    }

    // 힙에 밧줄의 길이를 추가하는 것은 O(log n) 시간에 완료됩니다.
    public void add(int element) {
        ensureCapacity();

        heap[size] = element;
        size++;

        heapifyUp();
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    // 루트의 폴링은 O(log n) 시간에 완료됩니다.
    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int element = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = -1;

        size--;

        heapifyDown();

        return element;
    }

    public void printHeap() {
        System.out.print("ROOT NODE: " + heap[0] + "\n");
        for (int i = 0; i < size; i++) {
            System.out.print("NODE: " + heap[i]);
            if (hasLeftChild(i)) {
                System.out.print(" LEFT NODE: " + heap[getLeftChildIndex(i)]);
            }
            if (hasRightChild(i)) {
                System.out.print(" RIGHT NODE: " + heap[getRightChildIndex(i)]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // 요소를 폴링한 후 힙을 수정합니다.
    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int largestChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                largestChildIndex = getRightChildIndex(index);
            }

            if (heap[index] > heap[largestChildIndex]) {
                swap(index, largestChildIndex);
            } else {
                break;
            }

            index = largestChildIndex;
        }
    }

    // 새로운 요소를 추가한 후 힙을 수정합니다.
    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private void swap(int index1, int index2) {
        int element = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = element;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        int[] ropesLength = {1, 3, 4, 6};
        MinHeap heap = new MinHeap();

        int result = heap.minimumCost(ropesLength);

        System.out.println("Result: " + result);
    }
}