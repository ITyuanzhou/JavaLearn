package com.company.exam;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by ZJZL_HP on 2018/6/1.
 */
public class SubString {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int num = scanner.nextInt();


        StringBuilder stringBuilder = new StringBuilder();
        for (char c:string.toCharArray()) {
            if(c>=48 && c<=57)
                continue;
            stringBuilder.append(c);
        }

        System.out.println(subString(stringBuilder.toString(),num));
    }

    private static String subString(String string,int num) throws UnsupportedEncodingException {
        int hanNum = 0;
        byte[] bytes = string.getBytes("GBK");
        for(int i=0;i<num;i++){
            if(bytes[i]<0)
                hanNum++;
        }

        if(hanNum%2 ==0)
            return new String(bytes,0,num,"GBK");
        else
            return new String(bytes,0,num-1,"GBK");



    }
}
