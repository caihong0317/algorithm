package com.caihong;

public class LoaderTest {
    public static void main(String[] args) {
        try {
            Class<?> aClass1 = classLoader1.loadClass("com.caihong.TestLoad");
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
            Class<?> aClass2 = classLoader2.loadClass("com.caihong.TestLoad");
            System.out.println(classLoader1 == classLoader2);
            System.out.println(aClass1 == aClass2);
            System.out.println("master 的修改");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

     public void work(){
        System.out.println("do working");
        System.out.println("do working");
    }
}
