package com.gardenia.jvm.classloader;

/**
 * 静态代码块从上往下执行
 *
 *
 *
 */
public class MyTest6 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("counter1=" + Singleton.counter1);
        System.out.println("counter2=" + Singleton.counter2);
    }

}

class Singleton {

    public static int counter1 = 1;// 准备阶段，赋初始值0，初始化阶段，赋值为1

    // 放置在构造函数后面之后，结果就变成了counter2=0
//    public static int counter2 = 0;

    // 准备阶段，赋初始值null，初始化阶段，赋值new Singleton()
    // 这时调用构造函数，count1++结果为2，counter2默认值加1结果为1，
    // 但是在初始化阶段执行到 public static int counter2 = 0;时，又给counter2赋值为0
    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;//准备阶段的意义
        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }


}
