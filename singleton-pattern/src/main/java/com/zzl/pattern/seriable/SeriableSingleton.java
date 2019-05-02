package com.zzl.pattern.seriable;

import java.io.Serializable;

public class SeriableSingleton implements Serializable {

    private SeriableSingleton() {
    }

    private static final SeriableSingleton INSTANCE = new SeriableSingleton();

    public static SeriableSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve(){
        return  INSTANCE;
    }
}
