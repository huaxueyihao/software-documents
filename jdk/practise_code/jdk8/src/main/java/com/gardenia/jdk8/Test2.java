package com.gardenia.jdk8;

@FunctionalInterface
interface MyInterface2 {

    void test();

    String toString();
}

public class Test2 {

    public void myTest(MyInterface2 myInterface2){
        System.out.println(1);
        myInterface2.test();
        System.out.println(2);
    }


    public static void main(String[] args) {
        Test2 test2 = new Test2();
        // 传统方式
        test2.myTest(new MyInterface2() {
            @Override
            public void test() {
                System.out.println("myTest");
            }
        });
        // lambda表达式
        test2.myTest(()->{
            System.out.println("mytest");
        });

        //
        MyInterface2 myInterface2 = ()->{
            System.out.println("hello");
        };


    }
}
