package com.eltobeski.LeetCode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Pair<Integer,Integer>> characterPairMap = new HashMap<>();
        populateMap(characterPairMap);
        if(s.length()==1){
            return characterPairMap.get(s.charAt(0)).getValue();
        }
        Deque<Pair<Integer,Integer>> characters = new ArrayDeque<>();
        characters.push(characterPairMap.get(s.charAt(s.length()-1)));
        int num = characterPairMap.get(s.charAt(s.length()-1)).getValue();
        for (int i = s.length()-2; i >=0; i--) {
            Pair<Integer,Integer> currentPair = characterPairMap.get(s.charAt(i));

            if(characters.isEmpty())
            {
                num += currentPair.getValue();
                characters.push(currentPair);
                continue;
            }
            if(currentPair.getKey()<characters.peek().getKey()){
                num -= currentPair.getValue();
                characters.pop();
            }
            else{
                num += currentPair.getValue();
            }
            characters.push(currentPair);
        }
        return num;
    }


    private static void populateMap(Map<Character, Pair<Integer,Integer>> romanMap){
        romanMap.put('I',new Pair<>(0,1));
        romanMap.put('V',new Pair<>(1,5));
        romanMap.put('X',new Pair<>(2,10));
        romanMap.put('L',new Pair<>(3,50));
        romanMap.put('C',new Pair<>(4,100));
        romanMap.put('D',new Pair<>(5,500));
        romanMap.put('M',new Pair<>(6,1000));

    }


    public static void main(String[] args) {
        System.out.println("III:"+romanToInt("III"));
        System.out.println("LVIII:"+romanToInt("LVIII"));
        System.out.println("MCMXCIV:"+romanToInt("MCMXCIV"));
        System.out.println("MMMCMXXXIV:"+romanToInt("MMMCMXXXIV"));
        System.out.println("MCMXXXIV:"+romanToInt("MCMXXXIV"));
        System.out.println("LI:"+romanToInt("LI"));

    }
}
