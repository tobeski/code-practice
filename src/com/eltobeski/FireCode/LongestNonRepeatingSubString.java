package com.eltobeski.FireCode;

import java.util.HashMap;

public class LongestNonRepeatingSubString {
    public static int longestNRSubstringLen(String input) {
        int length = 0;
        String currentSubString = "";

        if (input == null || input.length() == 0)
            return length;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (currentSubString.indexOf(c)== -1) {
                currentSubString += c;
            } else {
                currentSubString = currentSubString.substring(currentSubString.indexOf(c)+1);
                currentSubString += c;
            }
            if (currentSubString.length() > length)
                length = currentSubString.length();
        }
        return length;


    }
    public static int longestNRSubstringLenV2(String input) {
        if(input==null)
            return 0;
        char[] array = input.toCharArray();
        int prev = 0;

        HashMap<Character, Integer> characterMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (!characterMap.containsKey(array[i])) {
                characterMap.put(array[i], i);
            } else {
                prev = Math.max(prev, characterMap.size());
                i = characterMap.get(array[i]);
                characterMap.clear();
            }
        }
        return Math.max(prev, characterMap.size());
    }

    public static void main(String[] args) {
        System.out.println(longestNRSubstringLenV2("ABCDBEFALKLAMM"));
    }
}
