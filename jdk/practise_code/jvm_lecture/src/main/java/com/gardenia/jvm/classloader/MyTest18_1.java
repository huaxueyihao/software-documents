package com.gardenia.jvm.classloader;

public class MyTest18_1 {

    public static void main(String[] args) throws ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/User/amao/Desktop");


        Class<?> clazz = loader1.loadClass("com.gardenia.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader : " + clazz.getClassLoader());

    }

}
