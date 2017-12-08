package com.company.threadpool;

/**
 * Created by ZJZL_HP on 2017/12/6.
 */
public class TestThreadPool {

    public static void main(String[] args) {
        // 创建3个线程的线程池
        ThreadPool t = ThreadPool.getThreadPool(5);
        t.execute(new CustomTask[] { new CustomTask(), new CustomTask(), new CustomTask()});
        t.execute(new CustomTask[] { new CustomTask(), new CustomTask(), new CustomTask()});

        t.destroy();// 所有线程都执行完成才destory
    }

    // 任务类
     static class CustomTask {
        private static int i = 1;

        public void run(int workTheardCode) {// 执行任务
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(CustomTask.class){
                System.out.println("任务 " + (i) + " 由工作线程 "+workTheardCode +" 完成");
                i++;
            }
        }
    }
}
