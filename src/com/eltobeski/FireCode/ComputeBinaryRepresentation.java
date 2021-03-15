package com.eltobeski.FireCode;

public class ComputeBinaryRepresentation {
    public static String computeBinary(int val) {
        if(val == 0)
            return "0";
        if(val == 1)
            return "1";

        int remainder = val%2;
        val = val/2;

        return computeBinary(val) + remainder;
    }

    public static void main(String[] args){
        System.out.println(computeBinary(7));
    }
}
