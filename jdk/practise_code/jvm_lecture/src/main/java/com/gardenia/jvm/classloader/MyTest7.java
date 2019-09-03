package com.gardenia.jvm.classloader;

public class MyTest7 {


    public static void main(String[] args) throws ClassNotFoundException {

        // 是有根类加载的
        Class<?> clazz = Class.forName("java.lang.String");
        // null
        System.out.println(clazz.getClassLoader());

        //AppClassLoader 系统类加载器
        Class<?> clazz2 = Class.forName("com.gardenia.jvm.classloader.C");
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(clazz2.getClassLoader());
    }

}

class C{

}
