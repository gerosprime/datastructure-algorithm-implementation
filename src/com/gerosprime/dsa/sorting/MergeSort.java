package com.gerosprime.dsa.sorting;

import com.gerosprime.dsa.utils.ArrayUtils;

import java.util.Arrays;

public class MergeSort {

    private int[] merge(int[] left, int[] right) {

        int mergeLength = left.length + right.length;
        int[] result = new int[mergeLength];

        int l = 0;
        int r = 0;
        int i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r])
                result[i] = left[l++];
            else
                result[i] = right[r++];
            i++;
        }

        if (l < left.length)
            System.arraycopy(left, l, result, i, mergeLength - i);

        if (r < right.length)
            System.arraycopy(right, r, result, i, mergeLength - i);


        return result;

    }

    private int[] mergeSort(int[] nums) {

        if (nums.length == 1)
            return nums;

        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);

    }

    public static void main(String[] args) {

        int[] items = {5,4,3,2,1};

        items = new MergeSort().mergeSort(items);
        ArrayUtils.printIntegerArray(items);
        //SortChecker.isSortedAscending();

    }

}
