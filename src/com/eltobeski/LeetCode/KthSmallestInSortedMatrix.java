package com.eltobeski.LeetCode;

public class KthSmallestInSortedMatrix {

    /*
    Approach
    1. Row and column are in ascending order so at any point the two immediate larger values
    to a certain value are the value one row below it and one column in front
    2. Get these two values of they exist and add Priority queue
    3. Keep looping through the minimum till you get to point k
     */
//    public int kthSmallest(int[][] matrix, int k) {
//
//    }

//    public static void main(String[] args) {
//        KthSmallestInSortedMatrix ksm = new KthSmallestInSortedMatrix();
//        int[][] matrixx = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
//        ksm.kthSmallest(matrixx,8);
//    }
}
