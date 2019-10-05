package com.gardenia.jvm.bytecode;


/**
 * 方法的静态分派：
 * g1的声明类型Grandpa是静态类型，而g1的实际类型（真正指向的类型）是Father
 *
 * 可以得到一个结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多态的一种体现），
 * 实际类型是在运行期方可确定
 *
 *
 */
public class MyTest5 {

    // 方法的重载，是一种静态的行为，而不是根据实际类型，方法重载是在编译期就可以完全确定的
    //
    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }
    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();
        MyTest5 myTest5 = new MyTest5();
        // grandpa
        // grandpa
        myTest5.test(g1);
        myTest5.test(g2);

    }
}

class Grandpa{

}

class Father extends Grandpa{

}

class Son extends Father{

}
