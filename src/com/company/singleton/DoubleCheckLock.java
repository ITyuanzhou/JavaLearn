package com.company.singleton;

/** 双重锁模式DCL
 * instance = new DoubleCheckLock();
 * 这个步骤，其实在jvm里面的执行分为三步：
 * 1.在堆内存开辟内存空间
 * 2.在堆内存中实例化SingleTon里面的各个参数
 * 3.把对象指向堆内存空间
 * 由于jvm存在乱序执行功能，所以可能在2还没执行时就先执行了3，如果此时再被切换到线程B上，
 * 由于执行了3，INSTANCE 已经非空了，会被直接拿出来用，这样的话，就会出现异常。这个就是著名的DCL失效问题。
 *
 * 多线程编程注意三大问题：原子性、可见性、有序性
 * volatile可保证可见性、有序性
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


    private DoubleCheckLock(){}

}
