package com.zzl.pattern.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {

    private Object target;

    public Object getInstanse(Object target) {
        this.target = target;
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
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
