package com.gardenia.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparatorTest {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");
        Collections.sort(list, (item1, item2) -> item1.length() - item2.length());

        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()));
    }

}
