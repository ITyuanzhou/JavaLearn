package com.company.singleton;

/** 饿汉模式(不能lazy load)
 * Created by ZJZL_HP on 2017/12/6.
 */
public class Ehan {
    private static Ehan instance = new Ehan();

    public static Ehan GetInstance(){
        return instance;
    }
}
