package com.company.singleton;

/**
 * Created by ZJZL_HP on 2017/12/6.
 */
public class DoubleCheckLock {
    private volatile static DoubleCheckLock instance;

    public static DoubleCheckLock GetInstance(){
        if(instance == null){
            synchronized (DoubleCheckLock.class) {
                if (instance == null) {
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }

}
