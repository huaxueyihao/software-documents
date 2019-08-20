package com.gardenia.jvm.classloader;

public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.m);
    }

}

class MyParent2{
    public static final String str = "hello world";
    public static final short s = 7;
    public static final int  i = 128;
    public static final int  m = 1;
    static{
        System.out.println("MyParent2 static block");
    }
}
