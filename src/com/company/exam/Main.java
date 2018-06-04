package com.company.exam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);

       String[] strings = scanner.nextLine().split(",");

        System.out.println(handle(strings[0],strings[1]));
    }

    private static int handle(String a,String b){

       return Integer.parseInt(reverse(a)) + Integer.parseInt(reverse(b));

    }

    private static String reverse(String string){
        char[] chars = string.toCharArray();
        int length = chars.length;

        char temp;
        for(int i=0;i<length/2;i++){
            temp = chars[i];
            chars[i] = chars[length-i-1];
            chars[length-i-1] = temp;
        }

        return String.valueOf(chars);
    }
}
