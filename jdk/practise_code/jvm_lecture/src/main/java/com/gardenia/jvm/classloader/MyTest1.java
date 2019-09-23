package com.gardenia.jvm.classloader;

/**
 * 1.对于静态字段来说，只有指定定义了该字段的类才会被初始化
 * 2.当一个雷在初始化时，要求其父类全部都已经初始化完毕了
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 * -XX:+<option> 表示开启option选项
 * -XX:-<option> 表示关闭option选项
 * -XX:<option>=<value> 表示option选项的值设置为value
 */
public class MyTest1 {

    public static void main(String[] args) {

        System.out.println(MyChild1.str);
    }

}

class MyParent1 {
    public static String str = "hello word";

    static {
        System.out.println("MyParent1 static block ");
    }

}

class MyChild1 extends MyParent1 {

    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }

}
