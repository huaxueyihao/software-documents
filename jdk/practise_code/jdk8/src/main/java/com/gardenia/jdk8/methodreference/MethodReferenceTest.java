package com.gardenia.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * 要保证引用的方法的入参和lambda表达式的入参是一致的
 *
 */
public class MethodReferenceTest {

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

        students.sort(studentCompartor::compareStudentByName);
        students.forEach(student -> System.out.println(student.getName() + " " + student.getAge()));



    }

}
