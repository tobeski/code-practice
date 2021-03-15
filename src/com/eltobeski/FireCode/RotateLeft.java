package com.eltobeski.FireCode;

//Rotate Left k amount of times
public class RotateLeft {
    public static int[] rotateLeft(int[] arr, int k) {
        if (arr == null) {
            return arr;
        }
        int length = arr.length;
        k = k % length;
        int position;
        if (k == 0) {
            return arr;
        }
        int i = 0;
        int[] newArray = new int[length];

        while (i < length) {
            position = (length + i - k) % length;
            newArray[position] = arr[i];
            i++;
        }
        return newArray;

    }
}
