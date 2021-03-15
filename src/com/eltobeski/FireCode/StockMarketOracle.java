package com.eltobeski.FireCode;

public class StockMarketOracle {

    public static int maxProfit(int[] a) {
        int profit = 0;
        int length = a.length;

        for(int i=1;i<length;i++){
            if(a[i]>a[i-1]){
                profit += a[i]-a[i-1];
            }
        }
              return profit;

    }
}
