package com.zzl.pattern.register;
/**
 * Description:
 * @author zzl
 */
public enum EnumSingleton {
    /**
     *  优点：避免序列化和反射，代码简洁
     *
     */
    //
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
