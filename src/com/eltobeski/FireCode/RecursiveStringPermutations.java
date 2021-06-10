package com.eltobeski.FireCode;

import java.util.*;

public class RecursiveStringPermutations {
    static Deque<char[]> deque = new ArrayDeque<>();
    static ArrayList<String> answer = new ArrayList<>();
    static Set<Character> characters = new HashSet<>();
    public static ArrayList<String> getPermutations(String s) {
        if(s==null||s.isEmpty())
            return answer;
        for (Character c:s.toCharArray()
             ) {
            deque.push(new char[]{c});
        }
        getPermutationsHelper(s);
        return answer;
    }

    //TODO NOT DONE!!!!!!!!!!!!!!!!!!
    public static String getPermutationsHelper(String s) {
        if(s.length()==1){
            return s;
        }

        String letters = "";
        for (Character c:s.toCharArray()
             ) {
            String permitted = s.replace(c.toString(),"");
            letters = c.toString() + getPermutations(permitted);
        }

return "HELP";



    }

    public static void main(String[] args) {

    }
}
