package com.company.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighestScore {

    public static void main(String[] args){
        int i=0;
        List<Integer> highestList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

            while (!scanner.hasNext("quit")) {
                String[] firstNums = scanner.nextLine().split(" ");
                int studentNums = Integer.valueOf(firstNums[0]);
                int operNums = Integer.valueOf(firstNums[1]); //操作数

                int[] studentSocres = new int[studentNums];
                String[] studentInitScores = scanner.nextLine().split(" ");
                for (i = 0; i < studentInitScores.length; i++) {
                    studentSocres[i] = Integer.valueOf(studentInitScores[i]);
                }

                for (i = 0; i < operNums; i++) {
                    String[] operArray = scanner.nextLine().split(" ");
                    if (operArray[0].equals("Q")) {
                        printHighestScore(highestList, studentSocres, Integer.valueOf(operArray[1]), Integer.valueOf(operArray[2]));
                    } else if (operArray[0].equals("U")) {
                        studentSocres[Integer.valueOf(operArray[1]) - 1] = Integer.valueOf(operArray[2]);
                    } else {
                    }
                }

            }

        for (Integer num:highestList) {
            System.out.println(num);
        }

    }

    private static void printHighestScore(List<Integer> highestList,int[] studentSocres,int begin,int end){
        int highest = 0;
        begin--;
        end--;
        if(begin > end){
            int temp = end;
            end = begin;
            begin = temp;
        }
        for(;begin<=end;begin++){
            if(studentSocres[begin] >highest){
                highest = studentSocres[begin];
            }
        }
        highestList.add(highest);
    }
}
