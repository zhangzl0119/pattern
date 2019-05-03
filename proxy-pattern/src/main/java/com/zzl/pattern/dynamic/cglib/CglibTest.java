package com.zzl.pattern.dynamic.cglib;

import static net.sf.cglib.core.DebuggingClassWriter.DEBUG_LOCATION_PROPERTY;

public class CglibTest {
    public static void main(String[] args) {

//        System.setProperty(DEBUG_LOCATION_PROPERTY, "C://sql/cglib_class");
        long startTime = System.currentTimeMillis();
        Customer instanse = (Customer) new CglibMeipo().getInstanse(Customer.class);
        System.out.println(instanse);
        instanse.findLove();
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println(endTime);
    }
}
