package com.eltobeski.FireCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class RepeatedElementsInArray {

    public static String duplicate(int[] numbers){
        if(numbers.length == 1) return "";
        TreeSet<Integer> ts = new TreeSet<>();
        Arrays.sort(numbers);
        for(int i=1;i< numbers.length ; i++){
            if(numbers[i] == numbers[i-1]) ts.add(numbers[i]);
        }

        return Arrays.toString(ts.toArray());




    }
}
