package com.company.exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ZJZL_HP on 2018/6/1.
 */
public class Print {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] inputStrings = scanner.nextLine().split(",");

        Queue<Integer> indexQueue = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();


        for (int i =0;i<inputStrings.length;i++) {
            indexQueue.offer(i);
            queue.offer(Integer.valueOf(inputStrings[i]));
        }

        String outputStr = "";
        while (!queue.isEmpty()){
            Integer pollInteger = queue.poll();
            Integer num = indexQueue.poll();
            if(hasBiger(queue,pollInteger)){
                queue.offer(pollInteger);
                indexQueue.offer(num);
            }else{
                outputStr = outputStr + num + ",";
            }
        }

        outputStr = outputStr.substring(0,outputStr.length()-1);

        System.out.println(outputStr);
    }

    private static boolean hasBiger( Queue<Integer> queue,Integer pollInteger){
        boolean flag = false;
        for (Integer value:queue) {
            if(value >pollInteger){
                flag = true;
                break;
            }
        }
        return flag;
    }
}


