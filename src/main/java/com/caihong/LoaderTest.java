package com.caihong;

public class LoaderTest {
    public static void main(String[] args) {
        System.out.println("dev 的修改2");
        ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader1);
        System.out.println(classLoader1.getParent());
        System.out.println(classLoader1.getParent().getParent());
        System.out.println("dev 的修改3");
        try {
            Class<?> aClass1 = classLoader1.loadClass("com.caihong.TestLoad");
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
            Class<?> aClass2 = classLoader2.loadClass("com.caihong.TestLoad");
            System.out.println(classLoader1 == classLoader2);
            System.out.println(aClass1 == aClass2);

            System.out.println("dev 的修改1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void say(){
        int i=1;
        System.out.println("world");
    }
}
