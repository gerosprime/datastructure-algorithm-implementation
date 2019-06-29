package com.gerosprime.dsa.sorting;

import com.gerosprime.dsa.utils.ArrayUtils;

public class QuickSort {

    public static void sort(Integer[] integers) {
        quickSort(integers, 0, integers.length - 1);
    }

    private static void quickSort(Integer[] integers, int indexStart, int indexEnd) {
        if (indexStart < indexEnd) {

            int partitionIndex = partition(integers, indexStart, indexEnd);
            quickSort(integers, indexStart, partitionIndex - 1);
            quickSort(integers,  partitionIndex + 1, indexEnd);
        }
    }

    private static int partition(Integer[] integers, int indexStart, int indexEnd) {

            int pivot = integers[indexEnd];
            int i = indexStart - 1;

            for (int x = indexStart; x <= (indexEnd - 1); x++) {
                if (integers[x] <= pivot) {
                    i++;
                    ArrayUtils.swapIntegers(integers, i, x);
                }
            }
            ArrayUtils.swapIntegers(integers, i + 1, indexEnd);

            return i + 1;
    }

    public static void main(String[] args) {
        Integer[] arrays = {13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        sort(arrays);
        ArrayUtils.printIntegerArray(arrays);
    }

}
