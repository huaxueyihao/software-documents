package com.gardenia.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyTest27 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql//localhost:3306/mytest", "root", "mysql");


//        Class<?> callerClass = Reflection.getCallerClass();
//        System.out.println(callerClass);


    }
}
