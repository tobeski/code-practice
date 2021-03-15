package com.eltobeski.FireCode;

public class MaxGainLargerToRightOfSmaller {
    public static int maxGain(int[] a) {
        int max= 0;
        int minimum = a[0];
        int difference ;

        for(int i=1;i<a.length;i++){
            difference = a[i]-minimum;
            if(difference>max){
                max = difference;
            }
            if(a[i]<minimum)
                minimum = a[i];

        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(maxGain(new int[]{90,4,5,6,9,1,2,17,17}));

    }
}
