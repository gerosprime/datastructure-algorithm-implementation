package com.gerosprime.dsa.search;

public class BinarySearch {

    public static int find(Integer[] integers, int key) {



        return binarySearch(integers, key, 0, integers.length);
    }

    private static int binarySearch(Integer[] integers, int key, int start, int end) {

        int middle = (end + start) / 2;

        if (key == integers[middle]) {
            return middle;
        }

        if (middle == start || middle == end) {
            return -1;
        }

        if (key < integers[middle]) {
            return binarySearch(integers, key, start, middle);
        } else if (key > integers[middle]){
            return binarySearch(integers, key, middle, end);
        } else {
            return -1;
        }

    }


    public static void main(String[] args) {
        Integer[] list = new Integer[10000];
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }

        System.out.println(find(list,10001));
    }
}
