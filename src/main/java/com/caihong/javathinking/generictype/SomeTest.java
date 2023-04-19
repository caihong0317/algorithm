package com.caihong.javathinking.generictype;

import java.util.ArrayList;

public class SomeTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        // list.add(1); // 导致编译报错，会做类型检查
        System.out.println(list);

        ArrayList<HasF> list1 = new ArrayList<>();
        list1.add(new HasF());
        list1.add(new SubHasF());
        for (HasF hasF : list1) {
            System.out.println(hasF.getClass().getSimpleName());/* HasF SubHasF*/
        }
    }
}
