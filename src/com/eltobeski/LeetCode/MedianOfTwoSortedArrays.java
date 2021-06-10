package com.eltobeski.LeetCode;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int mergedLength = nums1.length+ nums2.length;
        int[] mergedArray = new int[mergedLength];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;
        while(leftIndex<nums1.length||rightIndex<nums2.length) {

            if (leftIndex != nums1.length && rightIndex != nums2.length) {
                if (nums1[leftIndex] >= nums2[rightIndex]) {

                    mergedArray[mergedIndex] = nums2[rightIndex];
                    rightIndex++;

                } else {

                    mergedArray[mergedIndex] = nums1[leftIndex];
                    leftIndex++;

                }


            }
            else if(leftIndex != nums1.length){
                mergedArray[mergedIndex] = nums1[leftIndex];
                leftIndex++;

            }
            else
            {
                mergedArray[mergedIndex] = nums2[rightIndex];

                rightIndex++;
            }
            mergedIndex++;

        }
        double median = 0;
        if(mergedLength%2==0)
        {
            median = (mergedArray[mergedLength/2]+mergedArray[(mergedLength/2)-1])/2.0;
        }else {
            median = mergedArray[mergedLength/2];
        }


        return median;

    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{2},new int[]{}));
    }

}
