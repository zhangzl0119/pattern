package com.zzl.pattern.singleton;

import com.zzl.pattern.threadLocal.ThreadLocalSingleton;

public class ThreadLocalSingletonTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(new MyTread());
        Thread t2 = new Thread(new MyTread());
        t1.start();
        t2.start();
        System.out.println("End");

    }

    static class MyTread implements Runnable{

        @Override
        public void run() {
            ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + instance);
        }
    }
}
