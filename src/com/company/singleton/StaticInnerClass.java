package com.company.singleton;

/** 静态内部类
 * Created by ZJZL_HP on 2017/12/6.
 */
public class StaticInnerClass {
     private static class StaticInnerClassHolder{
         private static StaticInnerClass instance = new StaticInnerClass();
     }

     public static StaticInnerClass GetInstance(){
         return StaticInnerClassHolder.instance;
     }
}
