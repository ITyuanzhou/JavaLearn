package com.company.threadpool;

/** 一个简单的死锁例子
 * 每个人都拥有其他人需要的资源，同时又等待其他人拥有的资源，并且每个人在获得所有需要的资源之前都不会放弃已经拥有的资源。
 * Created by ZJZL_HP on 2018/8/27.
 */
public class DeadLock {
    public void run(){
        MyThread myThread = new MyThread();
        new Thread(myThread,"1").start();
        new Thread(myThread,"2").start();
    }

    public static void main(String[] args){
        new DeadLock().run();
    }


    public class MyThread implements Runnable{
        private Object o1 = new Object();
        private Object o2 = new Object();
        private boolean flag = true;

        @Override
        public void run(){
           if(flag){
               flag = false;
               synchronized (o1){
                   System.out.println(Thread.currentThread().getName()+"have o1");
                   try{
                       Thread.sleep(1000);
                   }catch (Exception e){}
                   synchronized (o2){
                       System.out.println(Thread.currentThread().getName()+"have o2");
                   }
               }
           }else{
               flag = true;
               synchronized (o2){
                   System.out.println(Thread.currentThread().getName()+"have o2");
                   try{
                       Thread.sleep(1000);
                   }catch (Exception e){}
                   synchronized (o1){
                       System.out.println(Thread.currentThread().getName()+"have o1");
                   }
               }
           }
        }
    }
}
