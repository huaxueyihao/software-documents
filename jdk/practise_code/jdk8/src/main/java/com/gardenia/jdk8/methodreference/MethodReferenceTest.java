package com.gardenia.jdk8.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 要保证引用的方法的入参和lambda表达式的入参是一致的
 * 方法引用的4中类型：
 *  1.类名::静态方法名
 *  2.引用名（对象名）::实例方法名
 *  3.类名::实例方法
 *  4.构造方法引用:类名::new
 *
 */
public class MethodReferenceTest {


    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }


    public static void main(String[] args) {

        Student student1 = new Student("zs", 30);
        Student student2 = new Student("ls", 20);
        Student student3 = new Student("w5", 50);
        Student student4 = new Student("zl", 40);


        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        // lambda 表达式方式
//        students.sort((studentParam1, studentParam2) -> Student.compareStudentByAge(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getName() + " " + student.getAge()));
//        System.out.println("-----------------------");
        // 方法引用方式,方法引用和lambda表达式是一样的效果，且没有做功能上的增强，只是语法糖
//        students.sort(Student::compareStudentByAge);
//        students.forEach(student -> System.out.println(student.getName() + " " + student.getAge()));

        System.out.println("-----------------------");
        // 不是静态方法，lambda
        StudentCompartor studentCompartor = new StudentCompartor();
//        students.sort((studentParam1, studentParam2) -> studentCompartor.compareStudentByName(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getName() + " " + student.getAge()));

//        students.sort(studentCompartor::compareStudentByName);
//        students.forEach(student -> System.out.println(student.getName() + " " + student.getAge()));


        // sort 接收的第一个参数调用的compareByAge方法
//        students.sort(Student::compareByAge);
//        students.forEach(student -> System.out.println(student.getName() + " " + student.getAge()));


//        List<String> cities = Arrays.asList("qingdao","chongqing","tianjin","beijing");
//        Collections.sort(cities,(city1,city2)->city1.compareToIgnoreCase(city2));
//        cities.forEach(System.out::println);
//        Collections.sort(cities,String::compareToIgnoreCase);


        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));

        System.out.println(methodReferenceTest.getString2("hello", String::new));

    }

}
