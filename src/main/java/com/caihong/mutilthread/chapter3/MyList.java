package com.caihong.mutilthread.chapter3;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("hello world");
    }

    public static int size() {
        return list.size();
    }
}
