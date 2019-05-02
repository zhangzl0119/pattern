package com.zzl.pattern.dynamic.zzl;

import java.lang.reflect.Method;

public interface ZZLInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
