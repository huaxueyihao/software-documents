package com.gardenia.jvm.classloader;

public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded: " + this.getClass().getClassLoader());


        System.out.println("from MyCat: " + MySample.class);
    }


}
