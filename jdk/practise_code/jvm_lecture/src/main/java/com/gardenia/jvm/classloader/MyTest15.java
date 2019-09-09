package com.gardenia.jvm.classloader;


public class MyTest15 {

    public static void main(String[] args) {

        String[] strings = new String[2];
        // null 根加载器
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("----------");
        MyTest15[] myTest15s = new MyTest15[2];
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(myTest15s.getClass().getClassLoader());
        System.out.println("----------");
        int[] ints = new int[2];
        // null 没有加载器
        System.out.println(ints.getClass().getClassLoader());
        System.out.println("----------");
        Integer[] integers = new Integer[2];
        // null 根加载器：加载jdk rt.jar下的包里的类
        System.out.println(ints.getClass().getClassLoader());


    }


}
