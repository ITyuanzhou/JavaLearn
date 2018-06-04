package com.company.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ZJZL_HP on 2018/6/4.
 */
public class Puke {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("-");

        Map<String,Integer> map = new HashMap<>();
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        map.put("6",6);
        map.put("7",7);
        map.put("8",8);
        map.put("9",9);
        map.put("10",10);
        map.put("J",11);
        map.put("Q",12);
        map.put("K",13);
        map.put("A",14);
        map.put("2",15);
        handle(map,strings[0],strings[1]);
    }


    private static void handle( Map<String,Integer> map,String left,String right){
        String[] leftArray = left.split(" ");
        String[] rightArray = right.split(" ");

        //大小王
        if((leftArray.length ==2 && left.length()>10) ||(rightArray.length ==2 && right.length()>10)){
            System.out.println("joker JOKER");
            return;
        }

        //炸弹(排除炸弹跟炸弹)
        if(leftArray.length ==4 && rightArray.length!=4){
            System.out.println(left);
            return;
        }
        if(rightArray.length ==4 && leftArray.length!=4){
            System.out.println(right);
            return;
        }

        //处理error
        if(leftArray.length != rightArray.length){
            System.out.println("ERROR");
            return;
        }

        //牌张数相同情况下比较
        String leftStr = leftArray[0];
        String rightStr = rightArray[0];


        if(map.get(leftStr) > map.get(rightStr)){
            System.out.println(left);
        }else{
            System.out.println(right);
        }

    }

}
