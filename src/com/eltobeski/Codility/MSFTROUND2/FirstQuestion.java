package com.eltobeski.Codility.MSFTROUND2;

import java.util.ArrayList;
import java.util.List;

public class FirstQuestion {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Integer.parseInt("string",2);
        int total = 0;
        for(int i=0;i<A.length-2;i++){
            int firstDiff = A[i+1]-A[i];

            int prev = A[i+1];
            for(int j=i+2;j<A.length;j++){
                if(total>1000000000)
                    return -1;
                int jDiff = A[j] - prev;
                if(firstDiff==jDiff)
                {
                    total++;
                    prev = A[j];

                }

                else
                    break;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,1,3,3,3,2,3,2,1,0};
        System.out.println(solution(arr));

    }


}
