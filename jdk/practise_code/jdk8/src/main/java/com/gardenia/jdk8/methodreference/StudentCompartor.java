package com.gardenia.jdk8.methodreference;

public class StudentCompartor {


    public  int compareStudentByName(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }

    public  int compareStudentByAge(Student student1, Student student2) {
        return student1.getAge() - student2.getAge();
    }

}
