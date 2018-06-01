package com.company.exam;

import java.util.Scanner;

/**
 * Created by ZJZL_HP on 2018/6/1.
 */
public class BitHandle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int dataLength = scanner.nextInt();
        scanner.nextLine();
        int[] longs = new int[dataLength];
        String[] strings = scanner.nextLine().split(" ");
        for (int i=0;i<strings.length;i++){
            String str = strings[i];
            if(str.indexOf("x")!=-1){
                str = str.substring(str.indexOf("x")+1,str.length());
            }

            Byte tByte = Byte.parseByte(str,16);
            String estr = Integer.toBinaryString((tByte & 0xFF) + 0x100).substring(1);
            char[] chars = estr.toCharArray();
            System.out.println("");
        }
    }
}
