package com.eltobeski.LeetCode;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int k = 0;
        if(numRows==1)
            return s;
        String[] strings = new String[numRows];
        while(k<s.length()){
            for (int i = 0; i < numRows-1&&k<s.length(); i++) {
                if(strings[i]==null){
                    strings[i] = "";
                }
                strings[i] +=s.charAt(k);
                k++;
            }

            if(k>=s.length())
                break;

            for (int i = numRows-1; i > 0&&k<s.length() ; i--) {
                if(strings[i]==null){
                    strings[i] = "";
                }
                strings[i] +=s.charAt(k);
                k++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String string:strings
             ) {
            sb.append(string);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("A", 1));
    }
}
