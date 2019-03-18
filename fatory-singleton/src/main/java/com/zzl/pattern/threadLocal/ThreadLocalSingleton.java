package com.zzl.pattern.threadLocal;

public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> LOCAL = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return LOCAL.get();
    }
}
