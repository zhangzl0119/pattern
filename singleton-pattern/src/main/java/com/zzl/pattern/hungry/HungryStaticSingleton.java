package com.zzl.pattern.hungry;
/**
 * Description:
 * @author zzl
 */
public class HungryStaticSingleton {
    private HungryStaticSingleton() {
    }

    private static final HungryStaticSingleton HUNGRY_STATIC_SINGLETON;

    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }

    public static HungryStaticSingleton getInstance() {
        return HUNGRY_STATIC_SINGLETON;
    }
}
