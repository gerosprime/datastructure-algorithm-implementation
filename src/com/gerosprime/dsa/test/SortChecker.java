package com.gerosprime.dsa.test;

import java.util.List;

/**
 * Created by Glenn on 5/5/2019.
 */
public class SortChecker {

    public static boolean isSortedAscending(List<Integer> integers) {

        System.out.print("[");

        for (int i = 0; i < integers.size() - 1; i++) {
            System.out.print(integers.get(i) + ", ");
        }
        System.out.print(integers.get(integers.size() - 1));
        System.out.print("]\n");

        for (int i = 0; i < integers.size() - 1; i++) {

            int num1 = integers.get(i);
            int num2 = integers.get(i + 1);

            if (num1 <= num2) {
                continue;
            } else {
                return false;
            }

        }


        return true;

    }

}
