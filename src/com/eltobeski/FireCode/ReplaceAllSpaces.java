package com.eltobeski.FireCode;

public class ReplaceAllSpaces {
    // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

    public static String replace(String a, String b) {

        if(b==null||b.isEmpty()){
            return a;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==' '){
                sb.append(b);
            }
            else{
                sb.append(a.charAt(i));
            }
        }

        return sb.toString();


    }

    public static void main(String[] args) {
        // write your code here
        System.out.println(replace("This is my string","ABG"));
    }
}
