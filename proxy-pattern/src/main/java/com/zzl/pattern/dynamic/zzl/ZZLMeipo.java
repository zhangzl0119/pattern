package com.zzl.pattern.dynamic.zzl;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ZZLMeipo implements ZZLInvocationHandler{

    private Object target;

    public Object getInstanse(Object target) {
        this.target = target;
        Class<?> aClass = target.getClass();
        return ZZLProxy.newProxyInstance(new ZZLClassLoader(), aClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("之后");
    }

    private void before() {
        System.out.println("之前");
    }
}
