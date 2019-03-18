package com.zzl.pattern.lazy;

/**
 *  懒汉模式： 在外部需要使用的时候才实例化
 *
 *  即可以节约内存空间，又可以保证线程安全
 *
 *  但是jvm存在乱序执行功能，DCL也会出现线程不安全的情况
 */
public class LazyDoubleCheckSingleton {
    private LazyDoubleCheckSingleton() {
    }
    // 这种写法在JDK1.5之前存在DCL的问题
//    private static LazyDoubleCheckSingleton lazy = null;

    private volatile static LazyDoubleCheckSingleton lazy = null;

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazy == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazy == null) {
                    lazy = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazy;
    }
}
