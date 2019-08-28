package com.gardenia.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {

        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 30);

        List<Person> personList = Arrays.asList(person1, person2, person3);

        PersonTest test = new PersonTest();
        List<Person> personResult = test.getPersonsByUsername("zhangsan", personList);
        personResult.forEach(person -> System.out.println(person.getUsername()));
        System.out.println("-------------------");
        List<Person> personsByAge2 = test.getPersonsByAge2(20, personList, (age, persons) -> {
            return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        });
        personsByAge2.forEach(person -> System.out.println(person.getUsername()));


    }

    public List<Person> getPersonsByUsername(String username, List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }

    public List<Person> getPersonsByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> {
            return personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        };
        return biFunction.apply(age, persons);
    }


    public List<Person> getPersonsByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }

}
