package com.gardenia.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test3 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.forEach(item -> System.out.println(item.toUpperCase()));

        List<String> list2 = new ArrayList<>();
        list.forEach(item -> list2.add(item.toUpperCase()));
        list2.forEach(item -> System.out.println(item));

        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));

        Function<String, String> function = String::toUpperCase;



    }

}

@FunctionalInterface
interface AInterface {
    void myMethod();
}

@FunctionalInterface
interface AInterface2 {
    void myMethod2();
}

