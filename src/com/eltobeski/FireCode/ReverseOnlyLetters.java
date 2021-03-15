package com.eltobeski.FireCode;

import java.util.*;

public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        //65-90 ,97-122
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        TreeMap<Integer, Character> specials = new TreeMap<>();
        for (int i = length - 1; i >= 0; i--) {
            char currentCharacter = s.charAt(i);

            if ((currentCharacter >= 65 && currentCharacter <= 90 || currentCharacter >= 97 && currentCharacter <= 122)) {
                sb.append(currentCharacter);
            } else {
                specials.put(i, currentCharacter);
            }
        }
        for (int i :
                specials.keySet()) {
            sb.insert(i, specials.get(i));
        }
        return sb.toString();
    }

    public static String reverseOnlyLetters2(String s) {
        if (s == null || s.isEmpty()) return s;

        char[] arr = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                list.add(i);
            }
        }

        // d c a 3 b a
        //list : 6 5 1 0

        // start = 1
        // end = size - 2

        // arr[list.get(start)] //a
        // arr[list.get(end)] //d

        // start++
        // end--

        // d c 1 2 3 a b

        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int front = list.get(start);
            int back = list.get(end);

            char temp = arr[front];
            arr[front] = arr[back];
            arr[back] = temp;

            start++;
            end--;
        }

        return new String(arr);
    }



    public static void main(String[] args) {
        // write your code here
        System.out.println(reverseOnlyLetters2("Test1ng-Leet=code-Q!"));
        System.out.println("Qedo1ct-eeLg=ntse-T!");
    }

}
