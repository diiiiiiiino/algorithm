package 자바코딩인터뷰완벽가이드.배열과문자열.배열.정렬된배열병합;

public class MergeArrays {
    public static int[] merge(int[][] arrs, int k) {
        if(arrs == null){
            throw new IllegalArgumentException();
        }

        if(k <= 0){
            throw new IllegalArgumentException();
        }

        MinHeap[] heap = new MinHeap[k];
        for(int i = 0; i < k; i++){
            heap[i] = new MinHeap(arrs[i][0], i, 0);
        }

        int len = 0;
        for(int i = 0; i < k; i++){
            len += arrs[i].length;
        }

        int[] result = new int[len];

        for(int i = 0; i < result.length; i++){
            heapify(heap, 0, k);

            MinHeap minHeap = heap[0];
            result[i] = minHeap.data;

            minHeap.currentIndex++;
            int[] subArray = arrs[minHeap.heapIndex];
            if(minHeap.currentIndex >= subArray.length){
                minHeap.data = Integer.MAX_VALUE;
            } else {
                minHeap.data = subArray[minHeap.currentIndex];
            }
        }

        return result;
    }

    private static void heapify(MinHeap[] heap, int root, int len){
        int smallest = root;
        int leftIndex = left(root);
        int rightIndex = right(root);

        if(leftIndex < len && heap[smallest].data > heap[leftIndex].data){
            smallest = leftIndex;
        }

        if(rightIndex < len && heap[smallest].data > heap[rightIndex].data){
            smallest = rightIndex;
        }

        if(smallest != root){
            swap(heap, smallest, root);
            heapify(heap, smallest, len);
        }
    }

    private static void swap(MinHeap[] heap, int i, int j){
        MinHeap temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static int left(int i){
        return (2 * i + 1);
    }

    private static int right(int i){
        return (2 * i + 2);
    }
}
