package com.eltobeski.FireCode;

import java.util.HashMap;

public class AreAllCharactersUnique {
    public static boolean areAllCharactersUnique(String str){
        if ( str == null||str.isEmpty() ){
            return true;
        }
        boolean[] array = new boolean[256];
        for (int i = 0; i<str.length(); i++){
            int pos = str.charAt(i);
            if(!array[pos]){
                array[pos] = true;
            }
            else{
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        // write your code here
        System.out.println(areAllCharactersUnique(null));
    }

}
