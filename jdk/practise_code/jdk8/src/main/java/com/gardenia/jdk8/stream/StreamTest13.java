package com.gardenia.jdk8.stream;

import com.gardenia.jdk8.methodreference.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest13 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);


        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        // // {lisi=[Student(name=lisi, age=90, score=20)], zhangsan=[Student(name=zhangsan, age=100, score=20), Student(name=zhangsan, age=80, score=40)], wangwu=[Student(name=wangwu, age=90, score=30)]}
//        Map<String, List<Object>> map = new HashMap<>();
//        for (Student student : students) {
//            map.computeIfAbsent(student.getName(), k -> new ArrayList<>()).add(student);
//        }
//        System.out.println(map);

        // {lisi=[Student(name=lisi, age=90, score=20)], zhangsan=[Student(name=zhangsan, age=100, score=20), Student(name=zhangsan, age=80, score=40)], wangwu=[Student(name=wangwu, age=90, score=30)]}
//        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
//        System.out.println(map);

        // {lisi=20.0, zhangsan=30.0, wangwu=30.0}
//        Map<String, Double> doubleMap = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
//        System.out.println(doubleMap);

//        分组，分区
        Map<Boolean, List<Student>> listMap = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(listMap);


    }

}
