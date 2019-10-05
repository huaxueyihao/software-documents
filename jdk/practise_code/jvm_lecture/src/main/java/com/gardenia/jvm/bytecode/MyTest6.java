package com.gardenia.jvm.bytecode;

/**
 * 方法的动态分派：
 * 方法的动态分派涉及一个重要概念：方法接收者
 *
 * invokevirtual字节码指令的多态查找的流程
 *
 * 比较方法重载和方法重写：
 * 方法重载是静态的，是编译器行为；方法重写是动态的，运行期行为；
 *
 *
 *
 */
public class MyTest6 {

    public static void main(String[] args) {

        Fruit apple = new Apple();

        Fruit orange = new Orange();

        // invokevirtual
        // Apple
        apple.test();
        // Orange
        orange.test();

        apple = new Orange();
        // Orange
        apple.test();

    }
}

/**
 *
 */
class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}
