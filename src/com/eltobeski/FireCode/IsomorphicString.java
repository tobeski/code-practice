package com.eltobeski.FireCode;

import java.util.HashMap;

public class IsomorphicString {
    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char characters1[] = new char[26];
        char characters2[] = new char[26];
        char array1[] = s.toCharArray();
        char array2[] = t.toCharArray();

        for (int i=0; i<array1.length; i++) {
            char c1 = array1[i];
            char c2 = array2[i];
            char character1 = characters1[c1-'a'];
            char character2 = characters2[c2-'a'];
            if (character1 == '\0' && character2 == '\0') {
                characters1[c1-'a'] = array2[i];
                characters2[c2-'a'] = array1[i];
                continue;
            }
            if (character1 == array2[i] && character2 == array1[i]) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean isIsomorphicAlt(String input1, String input2) {
        if(input1.length() != input2.length()) return false;
        else {
            HashMap<Character, Integer> hm1 = new HashMap<>();
            HashMap<Character, Integer> hm2 = new HashMap<>();
            for(int i=0; i < input1.length(); i++){
                Character c1 = input1.charAt(i);
                Integer val1 = hm1.get(c1) == null ? 1 : hm1.get(c1) + 1;
                hm1.put(c1,val1);

                Character c2 = input2.charAt(i);
                Integer val2 = hm2.get(c2) == null ? 1 : hm2.get(c2) + 1;
                hm2.put(c2,val2);

                if(!hm1.get(c1).equals(hm2.get(c2))) return false;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        // write your code here
        System.out.println(isIsomorphic("aaba","bbgb"));
        System.out.println(isIsomorphicAlt("aaba","bbgb"));

    }

}
