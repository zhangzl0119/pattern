package com.zzl.pattern.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static final Map<String, Object> IOC = new ConcurrentHashMap<>();

    public static Object getInstance(String name) {
        synchronized (IOC) {
            if (!IOC.containsKey(name)) {
                Object obj = null;
                try {
                    obj = Class.forName(name).newInstance();
                    IOC.put(name, obj);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            }else {
                return IOC.get(name);
            }
        }
    }
}
