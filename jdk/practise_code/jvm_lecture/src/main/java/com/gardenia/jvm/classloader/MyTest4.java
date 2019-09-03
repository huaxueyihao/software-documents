package com.gardenia.jvm.classloader;

public class MyTest4 {
    public static void main(String[] args) {
//        // 创建对象实例，对MyParent4主动使用
//        MyParent4 myParent4 = new MyParent4();
//        // 只加载一次静态代码块
//        MyParent4 myParent5 = new MyParent4();


        // 数组的创建不会加载静态代码块
        // 创建的实例不是MyParent4的类型
        MyParent4[] myParent4s = new MyParent4[1];
        // [Lcom.gardenia.jvm.classloader.MyParent4;
        // 代码没有显示的数组类型，由jvm在运行期创建出来的
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());

        System.out.println("========");
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());


    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}
