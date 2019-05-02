package com.zzl.pattern.hungry;
/**
 * Description: 饿汉式单例
 * @author zzl
 */
public class HungrySingleton {
    private HungrySingleton() {
    }

    /**
     *  优点： 没有任何锁，效率比较高，不存在任何安全问题
     *
     *  缺点： 类加载就初始化，浪费资源，消耗内存，存在浪费的情况
     *
     */

    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }
}
