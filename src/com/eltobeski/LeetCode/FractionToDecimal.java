package com.eltobeski.LeetCode;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        boolean isDecimal = false;
        int remainder = 0;

        while (true) {
            if (remainder == 0 && numerator == 0) break;

            int numberOfDigitsInNumerator = (numerator + "").toCharArray().length;
            int numberOfDigitsInDenominator = (denominator + "").toCharArray().length;
            int digitDifference = numberOfDigitsInDenominator - numberOfDigitsInNumerator;
            if((digitDifference>1||denominator>numerator)&&isDecimal) {
                numerator *= 10;
                for (int i = 1; i <= digitDifference; i++) {
                    if(numerator>denominator) break;
                    sb.append(0);
                    numerator = numerator * 10;
                }
            }
            if (!isDecimal) {
                sb.append(numerator / denominator).append(".");
                remainder = numerator % denominator;
                numerator = remainder;
                isDecimal=true;
                continue;
            }
            sb.append(numerator / denominator);
            if(remainder == numerator % denominator) {sb.deleteCharAt(sb.length()-1).append("(").
                    append(numerator / denominator).append(")");
            break;}
            remainder = numerator % denominator;
            numerator = remainder;




        }
        if(sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 30));
    }
}
