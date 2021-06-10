package com.eltobeski.FireCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountPathsDP {

    static int[][] memoisation = new int[10][10];

    public static int countPaths(int m, int n) {
        return countPathHelper(m, n);
    }

    public static int countPathHelper(int m, int n) {
        if (n == 1 || m == 1 || n == 0 || m == 0) {
            return 1;
        }

        if (memoisation[m][n] != 0) {
            return memoisation[m][n];
        }

        memoisation[m][n] = countPathHelper(m - 1, n) + countPathHelper(m, n - 1);

        return memoisation[m][n];
    }


    public static void main(String[] args) {
        System.out.println(countPaths(5, 5));
    }
}
