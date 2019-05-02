package com.zzl.pattern.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeipo implements MethodInterceptor {


    public Object getInstanse(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        before();
        Object invoke = methodProxy.invokeSuper(o, objects);
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
