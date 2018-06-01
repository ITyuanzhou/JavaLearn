package com.company.exam;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by ZJZL_HP on 2018/6/1.
 */
public class Date13 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int years = scanner.nextInt();
        int weeks = scanner.nextInt();

        if(years<0 || years>=400){
            System.out.println(-1);
            return;
        }

        if(weeks<0 || years>6){
            System.out.println(-1);
            return;
        }

        System.out.println(GetCount(years,weeks));
    }

    private static int GetCount(int years,int weeks){
        int count = 0;

        Calendar calendar = Calendar.getInstance();
        for(int i=0;i<years;i++){
            int year = 1900+ i;
            for(int m=0;m<12;m++){
                calendar.set(year,m,13);

                if((calendar.get(Calendar.DAY_OF_WEEK)-1)==weeks)
                    count++;
            }
        }
        return count;
    }
}
