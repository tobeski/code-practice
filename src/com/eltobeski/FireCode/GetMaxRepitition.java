package com.eltobeski.FireCode;

import java.util.HashMap;
import java.util.Map;

public class GetMaxRepitition {
    public static int getMaxRepetition(int[] a) {
        int[] holder = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            holder[i] = 0;
        }
        for (int num:a
             ) {
            holder[num] = holder[num]+1;
        }
        Map<String,Integer> maxMap = new HashMap<>();
        maxMap.put("max",0);
        maxMap.put("count",0);
        for (int i = 0; i < holder.length; i++) {

            if(holder[i]>maxMap.get("max")){
                maxMap.put("max",i);
                maxMap.put("count",holder[i]);
            }
        }

        return maxMap.get("max");



    }
}
