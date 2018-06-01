package com.company.algorithm;

/**
 * Created by ZJZL_HP on 2018/5/23.
 */
public class Sort {
    public static void main(String[] args){
        int[] array = {6,3,2,0,8,9,7,4,5,1};
        QuickSort(array,0,9);

        for (int i:array)
            System.out.print(i+" ");

    }

    //#region 非线性时间比较类排序（通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlog2n)，因此称为非线性时间比较类排序）

    //#region 交换排序

    /**
     * 快速排序
     * 基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序
     * @param array
     * @param left
     * @param right
     */
    public static void QuickSort(int[] array,int left,int right)
    {

    }


    private static void quick(int[] array,int left,int right){
        if(left> right)
            return;

        int temp,i,j,t;
        i = left;
        j = right;
        temp = array[i];

        while (i!=j){
            while(array[j] >= temp && i<j)
                j--;

            while (array[i] <= temp && i <j)
                i++;

            if(i<j){
                t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        array[left] = array[i];
        array[i] = temp;

        quick(array,left,i-1);
        quick(array,i+1,right);
    }
    //endregion

    //#region 插入排序

    //endregion

    //#region 选择排序

    //endregion

    //#region 归并排序

    //endregion

    //endregion





    //#region 线性时间非比较类排序


    //endregion
}
