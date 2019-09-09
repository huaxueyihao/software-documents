package com.gardenia.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);

        String resourceName="com/gardenia/jvm/classloader/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            // file:/Users/xxx/Documents/code_temp/study/git/software-documents/jdk/practise_code/jvm_lecture/target/classes/com/gardenia/jvm/classloader/MyTest13.class
            System.out.println(url);
        }
    }

}
