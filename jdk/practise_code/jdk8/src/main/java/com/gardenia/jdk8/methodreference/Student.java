package com.gardenia.jdk8.methodreference;

public class Student {

    private String name;

    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int compareStudentByName(Student student1, Student student2) {
        return student1.name.compareTo(student2.name);
    }

    public static int compareStudentByAge(Student student1, Student student2) {
        return student1.age - student2.age;
    }

}
