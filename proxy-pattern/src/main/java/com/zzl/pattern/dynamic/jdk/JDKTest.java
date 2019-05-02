package com.zzl.pattern.dynamic.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

public class JDKTest {
    public static void main(String[] args) throws Exception{
        Object obj = new JDKMeipo().getInstanse(new Boy());
        Method method = obj.getClass().getMethod("findLove");
        method.invoke(obj);


        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream fos = new FileOutputStream("C://sql/$Proxy0.class");
        fos.write(bytes);
        fos.close();

    }
}
