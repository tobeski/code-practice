package com.eltobeski.FireCode;

import java.util.*;

public class CompressString {
    public static String compressString(String text) {
        if (text == null||text.isEmpty()) return text;

        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            count++;

            if (i + 1 >= text.length() || text.charAt(i) != text.charAt(i + 1)) {
                builder.append(text.charAt(i));
                if (count > 1) {
                    builder.append(count);
                }
                count = 0;
            }

        }

        return builder.toString();
    }
    public  static void main(String[] args){
        System.out.println(compressString("aaaa/abbbbbaaagghaaaccccc/"));
//        System.out.println(("1,2,3,4,5,6,7,*,*,*,*,*,*,*,*".split(",")));
    }
}
