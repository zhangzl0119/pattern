package com.zzl.pattern.lazy;

/**
 *  懒汉模式： 在外部需要使用的时候才实例化
 */
public class LazySingleton {

    // 防止实例的而生成
    private LazySingleton() {
    }

    private static LazySingleton lazy = null;

    public synchronized static LazySingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySingleton();
        }
        return lazy;
    }
}
