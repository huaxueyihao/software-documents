package com.gardenia.jdk8;

@FunctionalInterface
public interface MyInterface {

    void  test();

    // 加上这个会报错
    //String myString();

    // 而这个不会报错
    // 重写了Object类的方法，不会向抽象接口的方法数量加1
    String toString();
}
