package com.company.exam;

import java.util.Scanner;

/**
 * Created by ZJZL_HP on 2018/6/1.
 */
public class SafeApple {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int m = Integer.valueOf(firstLine[0]);
        int n = Integer.valueOf(firstLine[1]);
        int[][] array = new int[m][n];


        for (int i = 0; i < m; i++) {
            String[] rowString = scanner.nextLine().split(" ");
            for (int j = 0; j < rowString.length; j++) {
                array[i][j] = Integer.valueOf(rowString[j]);
            }
        }

        System.out.println(GetMaxValue(array));
    }

    private static int GetMaxValue(int[][] array) {
        int m = array.length;
        int n = array[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = array[0][0];
        for(int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + array[0][i];
        }

        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + array[i][0];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = Math.max(array[i][j]+dp[i-1][j],array[i][j]+dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

}



