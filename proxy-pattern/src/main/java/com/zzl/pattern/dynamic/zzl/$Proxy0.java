package com.zzl.pattern.dynamic.zzl;

import java.lang.reflect.Method;

public class $Proxy0 implements com.zzl.pattern.dynamic.jdk.Person {
    ZZLInvocationHandler h;

    public $Proxy0(ZZLInvocationHandler h) {
        this.h = h;
    }

    @Override
    public void findLove() {
        try {
            Method m = com.zzl.pattern.dynamic.jdk.Person.class.getMethod("findLove", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    ;
}