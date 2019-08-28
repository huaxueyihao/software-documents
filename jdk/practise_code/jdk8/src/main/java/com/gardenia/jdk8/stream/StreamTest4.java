package com.gardenia.jdk8.stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

    public static void main(String[] args) {


//        Stream<String> stream = Stream.of("hello", "world", "helloworld");
//
//        String[] stringArray = stream.toArray(length -> new String[length]);
//
//        Arrays.asList(stringArray).forEach(System.out::println);


        Stream<String> stream = Stream.of("hello", "world", "helloworld");
//        List<String> list = stream.collect(Collectors.toList());
//        list.forEach(System.out::println);

        // 不懂
        //stream.collect(() -> new ArrayList<>(), (theList, item) -> theList.add(item), (theList1, theList2) -> theList1.addAll(theList2));
        // 不懂
        // stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

    }


}
