package com.zzl.pattern.dynamic.zzl;

import com.zzl.pattern.dynamic.jdk.Boy;
import com.zzl.pattern.dynamic.jdk.JDKMeipo;
import com.zzl.pattern.dynamic.jdk.Person;
import net.sf.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

import static net.sf.cglib.core.DebuggingClassWriter.DEBUG_LOCATION_PROPERTY;

public class ZZLTest {
    public static void main(String[] args) throws Exception{

        Object obj = new ZZLMeipo().getInstanse(new Boy());
        Method method = obj.getClass().getMethod("findLove");
        method.invoke(obj);



    }
}
