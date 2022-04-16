package com.eltobeski.LeetCode;
/////WIP Built somewhat of a graph


import java.util.*;

public class AlienDictionary {

    private static String alienDictionaryOrder(List<String> words) {
        if (words == null || words.isEmpty())
            return "";
        if (words.size() == 1)
            return words.get(0);
        int k = 0;
        Map<Character, Set<Character>> characterSetMap = new HashMap<>();
        for (int i = 1; i < words.size(); i++) {
            if (k <= words.get(i - 1).length()
                    && k <= words.get(i).length()) {
                if (words.get(i - 1).charAt(k) == words.get(i).charAt(k)) {
                    k++;
                    i--;
                } else {
                    Set<Character> characterSet;
                    Character character = words.get(i - 1).charAt(k);
                    if (characterSetMap.containsKey(character))
                        characterSet = characterSetMap.get(character);
                    else
                        characterSet = new HashSet<>();
                    characterSet.add(words.get(i).charAt(k));
                    characterSetMap.put(character,characterSet );
                    k=0;
                }
            }
            else {
                k=0;
            }
        }
        characterSetMap.size();
        return "wert¥f";
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("wrt");
        words.add("wrf");
        words.add("er");
        words.add("ett");
        words.add("rftt");
        String arrangement = alienDictionaryOrder(words);
        String correctArrangement = "wertf";

//        Assert.that(arrangement.equals(correctArrangement), "They are not equal");
    }
}
