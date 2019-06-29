package com.gerosprime.dsa.datastructure.array;

import com.gerosprime.dsa.utils.ArrayUtils;

public class DynamicArray {

    private static final int INITIAL_CAPACITY = 2;

    private Integer[] arrays;
    private int size;


    public DynamicArray() {
        arrays = new Integer[INITIAL_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void insert(int startIndex, Integer...item) {

        capacityCheck(item.length);

        int oldCapacity = size;
        Integer[] tempStorage = new Integer[oldCapacity - startIndex];

        System.arraycopy(arrays, startIndex, tempStorage, 0, tempStorage.length);

        // Insertion of new items
        for (int i = 0; i < item.length; i++) {
            arrays[startIndex + i] = item[i];
        }
        size += item.length;

        // Insert the remaining items back
        for (int i = 0; i < tempStorage.length; i++) {
            arrays[(startIndex + item.length) + i] = tempStorage[i];
        }
    }

    public void printContent() {
        ArrayUtils.printIntegerArray(arrays);
    }

    private void capacityCheck(int itemsInsertionSize) {

        if (size + itemsInsertionSize > arrays.length) {

            int newSize = arrays.length;
            while (newSize < size + itemsInsertionSize) {
                newSize *= 2;
            }

            Integer[] operatedArray = new Integer[newSize];

            // Copy items into new array
            System.arraycopy(arrays, 0, operatedArray, 0, arrays.length);

            arrays = operatedArray;
        }
    }


    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.insert(0, 1);
        dynamicArray.insert(dynamicArray.size, 2, 3, 4);

        dynamicArray.printContent();

        System.out.println();
        System.out.println(dynamicArray.size());
    }
}
