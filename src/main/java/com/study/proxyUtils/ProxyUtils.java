package com.study.proxyUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * 动态代理  (手写jdk的动态代理过程)
 */
public class ProxyUtils {

    /**
     * 1、得到一个java
     * 2、编译得到一个class
     * 3、newInstance 反射
     */

    public static Object newProxyInstance(Object target) throws Exception {
        //字符串拼接
        String content = "";
        //换行
        String line = "\n";
        //得到传入对象的接口
        Class targetInfo = target.getClass().getInterfaces()[0];

        //得到接口的名字
        String interfanceName = targetInfo.getSimpleName();
        //包名
        String packageNameContent = "package com.study.proxy" + line;
        //导包的拼接
        String importContent = "import " + targetInfo.getName() + ";" + line;
        //类的第一行
        String classFirstLineContent = "public class $Proxy implements " + interfanceName + "{" + line;

        String fieldContent = "private " + interfanceName + " target ;" + line;
        //   public ProxyAccountServiceImpl2(AccountService accountService){
        //        this.accountService=accountService;
        //    }
        //构造方法
        String constructorContent = "public $Proxy (" + interfanceName + " target){" + line +
                "this.target=target;" + line +
                "}" + line;
        //
        String methodsContent = "";

      /*  public List<Account> getAllAccount() {
            System.out.println("这是一个实现接口的静态代理");

            return accountService.getAllAccount();
        }*/
        //得到所有的方法
        Method[] methods = targetInfo.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            String returnTypeName = method.getReturnType().getSimpleName();
            //得到所有的参数
            Class[] args = method.getParameterTypes();
            String argsContent = "";
            String paramesContent = "";
            int i = 0;
            for (Class arg : args) {
                String simpleName = arg.getSimpleName();
                argsContent += simpleName + " p" + i + ",";
                paramesContent += " p" + i + ",";
                i++;
            }
            if (argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(",") - 1);
                paramesContent = paramesContent.substring(0, paramesContent.lastIndexOf(",") - 1);
            }
            methodsContent += " public " + returnTypeName + " " + methodName + "(" + argsContent + "){" + line +
                    //代理的方法写死
                    "System.out.println(\"这是一个实现接口的静态代理\");" + line
                    + "target." + methodName + "(" + paramesContent + ");"
                    + "}";
        }
        content = packageNameContent + importContent + classFirstLineContent + fieldContent + constructorContent +
                methodsContent + line + "}";
        File file = new File("d:\\com\\study\\proxy\\$Proxy.java");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.flush();
        fw.close();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable units =  fileManager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
        t.call();
        fileManager.close();

        URL[] urls = new URL[]{new URL("file:d:\\\\")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class clazz = urlClassLoader.loadClass("com.study.proxy.$Proxy");
        Constructor constructor = clazz.getConstructor(targetInfo);
        Object o = constructor.newInstance();
        return o;
    }
    //D:\JAVA_STUDY\src\main\java\com\study\proxyUtils\ProxyUtils.java
}


