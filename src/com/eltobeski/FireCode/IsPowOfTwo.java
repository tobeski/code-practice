package com.eltobeski.FireCode;

public class IsPowOfTwo {
    public static boolean isPowOfTwo(int num) {

        return (num & (num-1)) == 0;

    }
}
