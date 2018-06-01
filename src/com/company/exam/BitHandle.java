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

        String[] strings = scanner.nextLine().split(" ");
        char[] chars = new char[8*dataLength];

        for (int i=0;i<strings.length;i++){
            String str = strings[i];
            if(str.indexOf("x")!=-1){
                str = str.substring(str.indexOf("x")+1,str.length());
            }

            int num = Integer.parseInt(str,16);
            byte tByte = (byte) num;
            char[] charArray = Integer.toBinaryString((tByte & 0xFF) + 0x100).substring(1).toCharArray();

            for(int j=0;j<charArray.length;j++){
                chars[8*i+j] = charArray[j];
            }
        }

        int outputLength = scanner.nextInt();
        int[] output = new int[outputLength];
        scanner.nextLine();

        int currentIndex =0;
        for(int i=0;i<outputLength;i++){
            int outputbit = scanner.nextInt();
            scanner.nextLine();

            String str = new String(chars,currentIndex,outputbit);
            currentIndex += outputbit;

            output[i] = Integer.parseInt(str,2);
        }

        for (int num:output) {
            System.out.println(num);
        }
    }
}
