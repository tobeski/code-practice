package com.eltobeski.LeetCode;


public class PalindromeOnlyAlphaNumeric {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s == null)
            return true;
        int length = s.length();
        int start = 0;
        int end = length - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }


}
