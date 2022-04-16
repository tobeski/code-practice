package com.eltobeski.LeetCode;

public class StringWithoutAAAOrBBB {
     static String answer = "";
    public static String strWithout3a3b(int a, int b) {
        subHelper("",a,b,new boolean[]{false});
        return answer;
    }

    public static void subHelper(String s,int a,int b,boolean[] found){
        if(a==0 && b==0)
        {
            answer = s;
            found[0] = true;
            return;
        }
            String substring = s.length() > 2 ? s.substring(s.length() - 2) : s;
            if (a > 0 && !"aa".equals(substring)&&!found[0])
                subHelper(s + "a", a - 1, b,found);
            if (b > 0 && !"bb".equals(substring)&&!found[0])
                subHelper(s + "b", a, b - 1,found);
    }

    public static void main(String[] args) {
        System.out.println(strWithout3a3b(1,4));
    }

}
