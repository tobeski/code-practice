package com.eltobeski.Codility;

public class MissingInteger {
    public int solution(int[] A) {
        // write your code in Java SE 8

        //[1, 1, 0, 0, 0, -967, -232]
        // within the array 1 - n or n + 1
        // 1 -3 6 -4 -1 2
        boolean found = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1 && !found) found = true;
        }

        if (!found) return 1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) A[i] = 1;
        }

        for (int i = 0; i < A.length; i++) {
            int num = Math.abs(A[i]);

            if (num == A.length) {
                A[0] = -Math.abs(A[0]);
                continue;
            }

            if (num > 0 && num < A.length) {
                A[num] = -Math.abs(A[num]);
            }
        }

        int idx = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > 0) {
                return i;
            }
        }

        if (A[0] > 0) return A.length;

        return A.length + 1;

    }
}
