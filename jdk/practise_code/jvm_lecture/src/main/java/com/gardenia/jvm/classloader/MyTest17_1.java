package com.gardenia.jvm.classloader;

/**
 * 关于命名空间：
 * 1.子加载器所加载的类能够访问父加载器所加载的类
 * 2.父加载器锁加载的类无法访问子加载器所加载的类
 *
 *
 */
public class MyTest17_1 {

    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/amao/Desktop/");


        Class<?> clazz = loader1.loadClass("com.gardenia.jvm.classloader.MySample");
        System.out.println("class:" + clazz.hashCode());

        // 如果注释掉改行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat
        Object instance = clazz.newInstance();




    }


}
