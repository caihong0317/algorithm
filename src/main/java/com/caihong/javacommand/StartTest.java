package com.caihong.javacommand;

import java.util.Arrays;

public class StartTest {
    public static void main(String[] args) {
        String str = System.getProperty("str");
        if (str == null) {
            System.out.println("null");
        } else {
            System.out.println(str);
        }
        System.out.println(Arrays.toString(args));
    }
}