package com.gardenia.jdk8.stream;

import java.util.stream.Stream;

public class StreamTest6 {

    public static void main(String[] args) {
        // iterate 需要limit配合，否则为无限流
        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);
        System.out.println(stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).max());
        //
        stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).max().ifPresent(System.out::println);







    }


}
