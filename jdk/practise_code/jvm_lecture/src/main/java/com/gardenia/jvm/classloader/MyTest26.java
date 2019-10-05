package com.gardenia.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模式(获取-使用-还原)
 * <p>
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * try{
 * Thread.currentThread().setContextClassLoader(targetTccl);
 * myMethod();
 * }finally{
 * Thread.currentThread().setContextClassLoader(classLoader);
 * }
 * <p>
 * myMethod里面则调用了Thread.currentThread().getContextClassLoader()获取当前线程的上线文类加载器做某些事情。
 * <p>
 * 如果一个类由加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的，(如果该依赖类之前没有被加载过的话)
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制。
 * <p>
 * 当高层提供了统一的接口让底层区实现，同时又要在高层加载(或实例化)低层的类时，就必须要通过线程上下文类加载器来帮助高层的ClassLoader
 * 找到并加载该类。
 */
public class MyTest26 {

    public static void main(String[] args) {


        // 手动设置加载器，和没有设置一样的结果
        //Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader());

        // 扩展类加载器，mysql驱动肯定加载不了
        // 当前线程上下文类加载器：sun.misc.Launcher$ExtClassLoader@511d50c0
        // ServiceLoader的类加载器：null
        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            //driver: class com.mysql.jdbc.Driver , loader: sun.misc.Launcher$AppClassLoader@18b4aac2
            //driver: class com.mysql.fabric.jdbc.FabricMySQLDriver , loader: sun.misc.Launcher$AppClassLoader@18b4aac2
            System.out.println("driver: " + driver.getClass() + " , loader: " + driver.getClass().getClassLoader());
        }

        //当前线程上下文类加载器：sun.misc.Launcher$AppClassLoader@18b4aac2
        //ServiceLoader的类加载器：null
        System.out.println("当前线程上下文类加载器：" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器：" + ServiceLoader.class.getClassLoader());


    }

}
