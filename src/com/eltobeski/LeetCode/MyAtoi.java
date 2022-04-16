package com.eltobeski.LeetCode;

public class MyAtoi {
    public static int myAtoi(String s) {
        Long num = 0L;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        boolean negative = false;
        if (s.charAt(0) == '-') {
            negative = true;
            s = s.substring(1);
        }
        else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        for(Character c:s.toCharArray()){
            if(Character.isDigit(c))
                sb.append(c);
            else break;
        }
        if(sb.length()==0)
            return 0;
        num = Long.valueOf(sb.toString());
        if ((num > (1L * Math.pow(2, 31))&&negative)) {
            return Integer.MIN_VALUE;
        }
            else if(num > (1L * (Math.pow(2, 31)-1))){
                return Integer.MAX_VALUE;
        }

        if (negative)
            return -1 * num.intValue();
        else
            return
                    num.intValue();

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
