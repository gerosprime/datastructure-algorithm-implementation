package com.gerosprime.dsa.search;

public class BinarySearch {

    public static int find(Integer[] integers, int key) {



        return binarySearch(integers, key, integers.length,0, integers.length);
    }

    private static int binarySearch(Integer[] integers, int count, int key, int start, int end) {

        int middle = (end + start) / 2;

        if (key == integers[middle]) {
            System.out.println("Count" + count);
            return middle;
        }

        if (middle == start || middle == end) {
            System.out.println(count);
            return -1;
        }

        if (key < integers[middle]) {
            return binarySearch(integers, count / 2, key, start, middle);
        } else if (key > integers[middle]){
            return binarySearch(integers, count / 2, key, middle, end);
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
