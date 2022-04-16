package com.eltobeski.LeetCode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int[] mergedArray = new int[nums2Length+nums1Length];
        int i=0;
        int j=0;
        int k=0;
        boolean even = (nums1Length+nums2Length)%2==0;
        int mid = (nums1Length+nums2Length)/2;

        while(i<nums1Length&&j<nums2Length){
            if(i+j==mid+2)
                break;

            if(nums1[i]<nums2[j])
            {
                mergedArray[k] = nums1[i];
                k++;
                i++;
            }
            else{
                mergedArray[k] = nums2[j];

                k++;
                j++;
            }

        }

        while(i<nums1Length&&i+j<mid+2){
            mergedArray[k] = nums1[i];
            k++;
            i++;
        }
        while(j<nums2Length && i+j<mid+2){
            mergedArray[k] = nums2[j];
            k++;
            j++;
        }
        if(even){
            return (mergedArray[mid-1]+mergedArray[mid])/2.0;
        }
        else{
            return mergedArray[mid];
        }
    }
}
