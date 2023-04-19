package com.caihong.javaVM;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class GenericType<E> {
    public void doSomething(Object obj){
/*
        if (obj instanceof E){

        }
        E e = new E();
        E[] array = new E[5];
*/
    // 协变
        Object[] array = new String[5];
        array[0]="a";
        array[1]=10;

        List<String> list = new ArrayList<>();
        List o=list;

    }
/*

    public void method1(List<String> list){
    }
    public void method1(List<Integer> list){
    }

    public static String method2(List<String> list){
        return "";
    }
    public static int method2(List<Integer> list){
        return 1;
    }
*/

    public void test(List<Integer> list){
        Integer a =1;
        Integer b =2;
        Integer c =3;
        Integer d =3;
        Long e =3L;
        System.out.println(c==d);
        System.out.println(c==(a+b));
        System.out.println(c.equals((a+b)));
        System.out.println(d==(a+b));
    }

}
