package com.eltobeski.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    static Map<String, Integer> intDP;

    public static int uniquePaths(int m, int n) {
        intDP = new HashMap<>();
        int[] ans = new int[]{0};
        ans[0] = paths(m, n);
        return ans[0];
    }

    public static int paths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        String key = m + "-" + n;
        if (intDP.containsKey(key))
            return intDP.get(key);
        if( intDP.containsKey(n+"-"+m))
            return intDP.get(n+"-"+m);
        int numPaths = paths(m - 1, n) + paths(m, n - 1);
        intDP.put(key,numPaths);
        return numPaths;


    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
    }
}
