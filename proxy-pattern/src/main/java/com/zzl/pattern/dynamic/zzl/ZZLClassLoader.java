package com.zzl.pattern.dynamic.zzl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class ZZLClassLoader extends ClassLoader {

    private File classPathFile;

    public ZZLClassLoader() {
        String path = ZZLClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = ZZLClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File file = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (file.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;

                try {
                    in = new FileInputStream(file);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }

                    return defineClass(className, out.toByteArray(), 0, out.size());


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.findClass(name);
    }
}
