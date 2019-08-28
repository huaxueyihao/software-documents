package com.gardenia.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * optional 不要用于方法参数
 *
 */
public class OptionalTest2 {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("zs");
        Employee employee2 = new Employee();
        employee2.setName("ls");
        Employee employee3 = new Employee();
        employee3.setName("ww");

        List<Employee> employees = null;//Arrays.asList(employee1, employee2, employee3);
        Company company = new Company();
        company.setName("company");
        company.setEmployeeList(employees);

        Optional<Company> optional = Optional.ofNullable(company);
        List<Employee> list = optional.map(company1 -> company.getEmployeeList()).orElse(Collections.emptyList());
        System.out.println(list);


    }

}
