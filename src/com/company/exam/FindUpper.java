package com.company.exam;

import java.util.*;

/**
 * Created by ZJZL_HP on 2018/5/31.
 */
public class FindUpper {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println(SortString(inputString));
    }

    private static String FindUpper(String string){
        String returnStr = "";
        char[] stringChars = string.toCharArray();
        for(int i =0;i<string.length();i++){
            if(stringChars[i]>=65 && stringChars[i]<=90){
                returnStr = returnStr + stringChars[i];
            }
        }
        return returnStr;
    }

    private static String SortString(String string){
        String returnStr = "";
        String[] stringArray = string.split(" ");
        List<Integer> intArray = new ArrayList<>();
        for (int i=0;i<stringArray.length;i++){
            intArray.add(Integer.valueOf(stringArray[i]));
        }

        int temp =0;
        for(int i= 1;i<intArray.size();i++){
            boolean flag = false;
            for(int j=0;j<intArray.size()-i;j++){
                if(intArray.get(j) < intArray.get(j+1)){
                    temp = intArray.get(j+1);
                    intArray.set(j+1,intArray.get(j));
                    intArray.set(j,temp);
                    flag = true;
                }
            }

            if(!flag){
                break;
            }
        }

        returnStr = returnStr + intArray.get(0) + "";
        for (int i=1;i<intArray.size();i++){
            if(intArray.get(i) == intArray.get(i-1))
                continue;
            returnStr = returnStr + intArray.get(i) + " ";
        }

        return returnStr;
    }
}
