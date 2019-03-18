package com.zzl.pattern.lazy;

public class LazyInnerClassSingleton {

    /**
     *  虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，
     *   如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，
     *   其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕。
     *   如果在一个类的<clinit>()方法中有耗时很长的操作，
     *   就可能造成多个进程阻塞(需要注意的是，其他线程虽然会被阻塞，
     *   但如果执行<clinit>()方法后，其他线程唤醒之后不会再次进入<clinit>()方法。
     *   同一个加载器下，一个类型只会初始化一次。)，在实际应用中，这种阻塞往往是很隐蔽的。
     *
     *
     *   优点： 外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故不占内存
     *   这种方式不仅能保证线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化
     */

    private LazyInnerClassSingleton() {
        // 防止反射调用
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     *  static
     * @return
     */
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
