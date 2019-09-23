package com.gardenia.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super();// 系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "[" + classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked:" + className);
        System.out.println("class loader name:" + this.classLoaderName);
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        className = className.replace(".", "/");
        try {
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }


    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.gardenia.jvm.classloader.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        // com.gardenia.jvm.classloader.Mytest1@61bbe9ba
        //test(loader1);

        /**
         * 这个路径是系统类路径：所以加载器是应用系统类加载器
         *
         */
//        loader1.setPath("/Users/amao/Documents/code_temp/study/git/software-documents/jdk/practise_code/jvm_lecture/target/classes");

        /**
         * 将系统路径下的Mytest1.class拷贝到桌面里的如下路径，同时删除系统类路径下的Mytest1.class。
         * 这里是可以看到findClass的被执行了，说明系统类加载器没有加载成功，于是自定义加载器去桌面加载Mytest1.class
         */
        loader1.setPath("/Users/amao/Desktop/");

        Class<?> clazz = loader1.loadClass("com.gardenia.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

//        MyTest16 loader2 = new MyTest16("loader2");
//        loader2.setPath("/Users/amao/Desktop/");
//
//        Class<?> clazz2 = loader2.loadClass("com.gardenia.jvm.classloader.Mytest1");
//        System.out.println("class:" + clazz2.hashCode());
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2);


        /**
         * 这个加载使用的loader1的加载器，加载器之间的关系是包含关系，不是树形结构
         */
//        MyTest16 loader3 = new MyTest16(loader1,"loader3");
//        loader2.setPath("/Users/amao/Desktop/");
//
//        Class<?> clazz3 = loader3.loadClass("com.gardenia.jvm.classloader.Mytest1");
//        System.out.println("class:" + clazz3.hashCode());
//        Object object3 = clazz3.newInstance();
//        System.out.println(object3);


        /**
         * loader4 的加载器也是loader1
         */
//        MyTest16 loader4 = new MyTest16(loader3,"loader4");
//        loader2.setPath("/Users/amao/Desktop/");
//
//        Class<?> clazz4 = loader3.loadClass("com.gardenia.jvm.classloader.Mytest1");
//        System.out.println("class:" + clazz4.hashCode());
//        Object object4 = clazz4.newInstance();
//        System.out.println(object4);


        System.out.println();
        loader1 = null;
        clazz = null;
        object = null;
        System.gc(); // 触发gc

        Thread.sleep(100000);

        /**
         * 类加载器卸载
         * -XX:+TraceClassUnloading
         *
         * [Unloading class com.gardenia.jvm.classloader.Mytest1 0x00000007c0061028]
         *
         */
        loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/amao/Desktop/");

        clazz = loader1.loadClass("com.gardenia.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);

    }
}
