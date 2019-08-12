package com.gerosprime.dsa.merge;

import com.gerosprime.dsa.utils.ArrayUtils;

public class ArrayMerge {


    public static int[] mergeSorted(int[] a, int[] b) {

        int total = a.length + b.length;

        int m = a.length;
        int n = b.length;

        int indexN = 0;
        int indexM = 0;

        int[] result = new int[n + m];

        int i = 0;
        while (indexN < n && indexM < m) {

            if (a[indexM] < b[indexN])
                result[i] = a[indexM++];
            else
                result[i] = b[indexN++];

            i++;

        }

        if (indexN < n)
            System.arraycopy(b, indexN, result, i, result.length - i);

        if (indexM < m)
            System.arraycopy(a, indexM, result, i, result.length - i);

        return result;

    }

    public static void main(String[] args) {
        int[] a = {1,3,4,5,6,7,8,9,11,12};
        int[] b = {0,2,5,6,8,9,10};

        ArrayUtils.printIntegerArray(mergeSorted(a, b));
    }

}
