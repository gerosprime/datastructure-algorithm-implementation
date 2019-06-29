package com.gerosprime.dsa.utils;

public class ArrayUtils {

    public static void swapIntegers(Integer[] array, int index2, int index3) {
        int temp = array[index2];
        array[index2] = array[index3];
        array[index3] = temp;
    }

    public static void printIntegerArray(Integer[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.print("]");
    }

}
