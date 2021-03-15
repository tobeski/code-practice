package com.eltobeski.FireCode;

public class MergeTwoSortedArrays {

    public static int[] merge(int[] arrLeft, int[] arrRight){
        int totalLength = arrLeft.length + arrRight.length;

        int[] mergedArray = new int[totalLength];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;
        while(leftIndex!=arrLeft.length&&rightIndex!=arrRight.length){

            if(arrLeft[leftIndex] >= arrRight[rightIndex]){

                mergedArray[mergedIndex] = arrRight[rightIndex];
                rightIndex++;

            } else{

                mergedArray[mergedIndex] = arrLeft[leftIndex];
                leftIndex++;

            }

            mergedIndex++;

        }

        if(leftIndex==arrLeft.length){
            for(int i=mergedIndex;i<totalLength;i++){
                mergedArray[i] = arrRight[rightIndex];
                rightIndex++;
            }
        }
        else{
            for(int i=mergedIndex;i<totalLength;i++){
                mergedArray[i] = arrLeft[leftIndex];
                leftIndex++;
            }
        }
        return mergedArray;
    }
}
