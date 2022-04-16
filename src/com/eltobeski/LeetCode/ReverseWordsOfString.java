package com.eltobeski.LeetCode;

public class ReverseWordsOfString {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {
        String[] newString = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = newString.length-1 ; i >=0 ; i--) {
            if(!newString[i].trim().equals("")) {
                stringBuilder.append(newString[i]);
                stringBuilder.append(" ");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }


}
