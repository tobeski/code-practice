package com.eltobeski.FireCode;

import java.util.ArrayList;

//TODO complete this method
public class FindSpiral {
    public static ArrayList<Integer> findSpiral(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        ArrayList<Integer> answer = new ArrayList<>();

        while (m > 0 && n>0){
            // Left Movement
            for(int i=arr[0].length-n;i<n;i++){
                answer.add(arr[arr.length-m][i]);
            }

        }
        return answer;
    }
}
