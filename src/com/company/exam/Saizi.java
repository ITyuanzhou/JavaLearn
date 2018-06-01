package com.company.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ZJZL_HP on 2018/6/1.
 */
public class Saizi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        GetRete(num);
    }

    private static void GetRete(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                int x = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j > k) {
                        x += dp[i - 1][j - k];
                    }
                }
                dp[i][j] = x;
            }
        }
        ArrayList<ArrayList<String>> out = new ArrayList<>();
        for (int i = n; i <= 6 * n; i++) {
            ArrayList<String> list = new ArrayList<>();
            list.add(i + "");
            // String result = dp[n][i]+"";//输出次数
            String result = String.format("%.5f", ((double) dp[n][i]) / (n * 6));//输出概率
            list.add("" + result);
            out.add(list);
        }
        System.out.println(out.toString());

    }
}
