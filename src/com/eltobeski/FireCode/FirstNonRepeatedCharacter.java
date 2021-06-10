package com.eltobeski.FireCode;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static Character firstNonRepeatedCharacter(String str) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int stringLength = str.length();

        for (int i = 0; i < stringLength; i++) {
            Character character = str.charAt(i);
            if (!hashMap.containsKey(character)) {
                hashMap.put(character, 1);
            } else {
                int value = hashMap.get(character);
                hashMap.put(character, value + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            Character key = entry.getKey();
            int value = entry.getValue();
            if (value == 1)
                return key;

        }
        return null;
    }

    public static Character firstRepeatedVersionTwo(String str) {
        if (str == null || str.length() == 0) return null;

        int[] charQuantity = new int[256];
        for (char currentCharacter : str.toCharArray()) {
            charQuantity[currentCharacter] += 1;

        }
        for (char currentCharacter : str.toCharArray()) {
            if (charQuantity[currentCharacter] == 1) {
                return currentCharacter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // write your code here
        String str = "cbbdda";
        System.out.println(str.substring(str.indexOf('a')+1));
        System.out.println(firstRepeatedVersionTwo(str));
    }
}
