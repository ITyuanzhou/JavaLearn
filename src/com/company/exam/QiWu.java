package com.company.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ZJZL_HP on 2018/6/4.
 */
public class QiWu {

    // 两个数组，一个用来储存任意两个城市的最短距离，一个用来储存路径
    private static Integer[][] dist;
    private static Integer[][] path;
    // 定义不可达的距离为1000
    private final static int INF = 1000;

    public static void main(String[] args) {
        int beginCity = 5 - 1;// 出发城市
        int size = 6;
        Scanner sc = new Scanner(System.in);
        int endCity = sc.nextInt() - 1;// 因为储存在数组中，所以要减一
        int foggyCity = sc.nextInt() - 1;// 因为储存在数组中，所以要减一
        // 初始矩阵，表示各个城市之间的距离
        Integer[][] matrix = { { 0, 2, 10, 5, 3, INF }, { INF, 0, 12, INF, INF, 10 }, { INF, INF, 0, INF, 7, INF },
                { 2, INF, INF, 0, 2, INF }, { 4, INF, INF, 1, 0, INF }, { 3, INF, 1, INF, 2, 0 } };
        // 初始化那两个数组
        dist = new Integer[size][size];
        path = new Integer[size][size];
        // 设置起雾城市
        if (foggyCity != 0) {
            setFoggyCity(foggyCity, matrix);
        }
        // 使用floyd算法
        floyd(matrix);
        // 距离
        System.out.println(dist[beginCity][endCity]);
        // 路径
        ArrayList<Integer> list = new ArrayList<>();
        findPath(beginCity, endCity, list);
        // 路径每个值加1
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + 1);
        }
        if (dist[beginCity][endCity] == INF) {
            list.removeAll(list);
        }
        System.out.println(list);
    }

    // 调试,m没有调用该函数，不懂的可以用这个函数打印数组dist\path就会清除了
    public static void printMatrix(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    private static void findPath(int beginCity, int endCity, ArrayList<Integer> list) {
        list.add(beginCity);
        while (path[beginCity][endCity] != -1) {
            int midCity = path[beginCity][endCity];
            list.add(midCity);
            beginCity = midCity;
        }
        list.add(endCity);
    }

    /**
     * 最核心的辅助函数
     *
     * @param matrix
     */
    private static void floyd(Integer[][] matrix) {
        int size = matrix.length;
        // 为辅助数组赋值
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dist[i][j] = matrix[i][j];
                path[i][j] = -1;
            }
        }
        // floyd算法
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
    }

    // 设置起雾城市
    private static void setFoggyCity(int foggyCity, Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][foggyCity] = INF;
            matrix[foggyCity][i] = INF;
        }
    }


}
