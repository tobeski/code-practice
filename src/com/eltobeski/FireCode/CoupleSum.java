package com.eltobeski.FireCode;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class CoupleSum {
    public static int[] coupleSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();



        for(int i=0; i<numbers.length;i++){
            int value = target - numbers[i] ;
            if(!hm.containsKey(numbers[i])){
                hm.put(value,i+1);
                continue;
            }

                int index = hm.get(numbers[i]);
                return new int[]{index,i+1};

        }
        return numbers;
    }
    public static void main(String[] args) throws ParseException {
        // write your code here
        int[] arrayOfNumbers = {2, 8, 3, 4, 5, 6, 7, 9, 10};

        System.out.println(Arrays.toString(coupleSum(arrayOfNumbers,19)));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yy HH:mm");
       Date date =  simpleDateFormat.parse("01/08/20 00:00");
       date.toString();

    }
}
