package com.gardenia.jvm.classloader;

/**
 * 当前类加载器(Current ClassLoader)
 * 每个类都会使用自己的类加载器（即加载自身的类加载器）来去加载其他类（值得是锁依赖的类），
 *
 *
 *
 *
 *
 */
public class MyTest24 {

    public static void main(String[] args) {
        /**
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * null
         */
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());



    }

}
