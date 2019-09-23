package com.gardenia.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

public class MyTest19 {

    public static void main(String[] args) {

        // java -Djava.ext.dirs=./ com.gardenia.jvm.classloader.MyTest19
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());

    }


}
