package com.company.algorithm;


/**
 * Created by ZJZL_HP on 2017/12/28.
 */
public class StringOpetation {
    public static void main(String[] args){
        String testStr = "zhouyuan";
        System.out.println(Reverse1(testStr));
    }

    private static String Reverse(String str){
        char[] chars = str.toCharArray();
        int count = chars.length /2;
        for(int i=0;i<count;i++){
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        return String.valueOf(chars);
    }

    private static String Reverse1(String str){
        if(str == null || str.length() <=1)
            return str;
        return Reverse1(str.substring(1)) + str.charAt(0);
    }
}
