package com.eltobeski.FireCode;

public class BetterFibonacci {
    public static int betterFibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int x=0;
        int y=1;
        int temp = 1;
        for (int i = 2;i<=n;i++){
            temp= x+y;
            x=y;
            y=temp;
        }
        return temp;
    }

}
