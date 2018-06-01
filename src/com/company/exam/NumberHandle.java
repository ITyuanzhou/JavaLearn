package com.company.exam;

import java.util.Scanner;

/**
 * Created by ZJZL_HP on 2018/6/1.
 */
public class NumberHandle {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();

        int maxStart = 0;
        int maxEnd = 0;
        int currentStart = 0;
        int currentEnd = 0;
        boolean flag = false;
        for(int i = 0;i<chars.length;i++){
            if(chars[i]>=48 && chars[i]<=57){
                if(!flag){
                    currentStart = i;
                    flag = true;
                }
            }else{
                if(flag){
                    currentEnd = i;
                    flag =false;

                    if((currentEnd - currentStart)>=(maxEnd - maxStart)){
                        maxStart = currentStart;
                        maxEnd = currentEnd;
                    }
                }
            }
        }

        if(flag){
            currentEnd = chars.length;
            if((currentEnd - currentStart)>=(maxEnd - maxStart)){
                maxStart = currentStart;
                maxEnd = currentEnd;
            }
        }
        if(maxStart == maxEnd){
            System.out.println("");
            return;
        }

        System.out.println(string.substring(maxStart,maxEnd)+","+(maxEnd-maxStart));
    }
}
