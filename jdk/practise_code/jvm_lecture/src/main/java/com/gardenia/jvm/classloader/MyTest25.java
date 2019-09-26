package com.gardenia.jvm.classloader;

public class MyTest25 implements Runnable {

    private Thread thread;

    public MyTest25(){
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        ClassLoader contextClassLoader = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(contextClassLoader);
        //Class:class sun.misc.Launcher$AppClassLoader
        //Parent:class sun.misc.Launcher$ExtClassLoader
        System.out.println("Class:"+contextClassLoader.getClass());
        System.out.println("Parent:"+contextClassLoader.getParent().getClass());

    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
