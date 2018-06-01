package com.company.exam;

import java.util.Scanner;

public class Main {
    public String fileName;
    public int errorNum;
    public int times;

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       Main[] mainArray = new Main[8];

       while (scanner.hasNext()){
           save(mainArray,scanner.nextLine());

       }
    }

    private static void save(Main[] mainArray,String string){
        String[] strings = string.split(" ");
        String fileName = "";
        int index = strings[0].lastIndexOf("\\");


    }
}
