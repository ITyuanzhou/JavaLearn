package com.company.singleton;

/** 懒汉模式(效率低下)
 * Created by ZJZL_HP on 2017/12/6.
 */
public class Lanhan {
    private static Lanhan instance;

    public static synchronized Lanhan GetInstance(){
        if(instance == null)
            instance = new Lanhan();

        return instance;
    }
}
