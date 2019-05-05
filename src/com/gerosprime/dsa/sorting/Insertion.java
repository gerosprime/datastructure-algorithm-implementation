package com.gerosprime.dsa.sorting;

import com.gerosprime.dsa.test.SortChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Glenn on 5/5/2019.
 */
public class Insertion {


    /**
     *
     * Runtime: O(n * n)
     * Space: O(1)
     *
     * @param integers
     */

    public static void sort(List<Integer> integers) {

        for (int i = 1; i < integers.size(); i++) {

            int key = integers.get(i);

            int r = i - 1;

            while (r >= 0 && integers.get(r) > key) {
                integers.set(r + 1, integers.get(r));
                r--;
            }
            integers.set(r + 1, key);

        }
    }

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(5, 4, 3, 2, 2, 1));

        sort(integers);
        System.out.println("Sorted: " + SortChecker.isSortedAscending(integers));

    }

}
