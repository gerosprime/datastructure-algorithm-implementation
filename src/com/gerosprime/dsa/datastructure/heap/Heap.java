package com.gerosprime.dsa.datastructure.heap;

import com.gerosprime.dsa.utils.ArrayUtils;

public class Heap {

    private Integer[] arrays;
    private int heapSize;

    private boolean maxHeap;

    public Heap(Integer[] arrays, boolean maxHeap) {
        this.arrays = arrays;
        this.maxHeap = maxHeap;
        buildHeap();
    }

    public int max() {
        return arrays[0];
    }

    public int extractMax() {
        int max = arrays[0];

        arrays[0] = arrays[heapSize - 1];
        maxHeapify(0);

        return max;
    }

    private int computeLeft(int index) {
        // In Pseudo code 2 * index. Starting index is 1 instead of 0
        return (2 * index) + 1;
    }

    private int computeRight(int index) {
        // In Pseudo code 2 * index. Starting index is 1 instead of 0
        return (2 * index) + 2;
    }

    private int computeParent(int index) {
        return index % 2 == 0? (index / 2) - 1 : index / 2;
    }


    private void buildHeap() {
        this.heapSize = arrays.length;

        for (int i = (arrays.length / 2) - 1; i >= 0 ; i--) {
            maxHeapify(i);
        }
    }

    private void maxHeapify(int index) {

        int left = computeLeft(index);
        int right = computeRight(index);

        int largestIndex = index;

        if (left < heapSize && arrays[left] > arrays[index]) {
            largestIndex = left;
        }

        if (right < heapSize && arrays[right] > arrays[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != index) {
            ArrayUtils.swapIntegers(arrays, index, largestIndex);
            maxHeapify(largestIndex);
        }

    }

    public static void main(String[] args) {

        Integer[] integers = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7}; // {123, 65, 10, 45, 5, 3, 2, 4};

        Heap heap = new Heap(integers, true);

        ArrayUtils.printIntegerArray(integers);

        heap.extractMax();
        System.out.println();
        ArrayUtils.printIntegerArray(integers);

        heap.extractMax();
        System.out.println();
        ArrayUtils.printIntegerArray(integers);

    }
}
