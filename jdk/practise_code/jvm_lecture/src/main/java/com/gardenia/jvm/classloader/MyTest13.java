package com.gardenia.jvm.classloader;

/**
 * sun.misc.Launcher$AppClassLoader@18b4aac2 系统类
 * sun.misc.Launcher$ExtClassLoader@61bbe9ba 扩展类
 * null 根类
 */
public class MyTest13 {


    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

        //sun.misc.Launcher$AppClassLoader@18b4aac2 系统类
        //sun.misc.Launcher$ExtClassLoader@61bbe9ba 扩展类
        //null 根类
        while (null != classLoader){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }

}
