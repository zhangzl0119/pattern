package com.zzl.pattern.singleton;

import com.zzl.pattern.lazy.LazySingleton;

public class LazySingletonTest {

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
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + instance);
        }
    }
}
