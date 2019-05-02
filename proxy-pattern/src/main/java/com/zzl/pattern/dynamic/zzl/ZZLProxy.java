package com.zzl.pattern.dynamic.zzl;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ZZLProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(ZZLClassLoader loader,
                                          Class<?>[] interfaces,
                                          ZZLInvocationHandler h) {
        //1. 动态生成源代码.java文件
        String src = generateSrc(interfaces);

        //2.Java文件输出磁盘
        String filePath = ZZLProxy.class.getResource("").getPath();
        File file = new File(filePath + "$Proxy0.java");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();

            //3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager =
                    compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = manager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, javaFileObjects);
            task.call();
            manager.close();

            //4、编译生成的.class文件加载到jvm中来
            Class<?> proxyClass = loader.findClass("$Proxy0");
            Constructor<?> constructor = proxyClass.getConstructor(ZZLInvocationHandler.class);
            boolean delete = file.delete();

            //5、返回字节码重组以后新的代理对象
            return constructor.newInstance(h);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.zzl.pattern.dynamic.zzl;" + ln);
        sb.append("import com.zzl.pattern.dynamic.jdk.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements" + " " + interfaces[0].getName() + "{" + ln);
        sb.append("ZZLInvocationHandler h;" + ln);
        sb.append("public $Proxy0(ZZLInvocationHandler h){" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);
        for (Method method : interfaces[0].getMethods()) {
            sb.append("@Override" + ln);
            sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + " " + ")" + "{" + ln);
            sb.append("try{" + ln);
            sb.append("Method m=" + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + ln);
            sb.append("this.h.invoke(this,m,null);" + ln);
            sb.append("}catch(Throwable e){" + ln);
            sb.append("e.printStackTrace();" + ln);
            sb.append("}" + ln);
            sb.append("};" + ln);
        }


        sb.append("}" + ln);

        return sb.toString();

    }
}
