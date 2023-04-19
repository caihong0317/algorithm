package com.caihong.javaVM.oom;

import java.util.HashSet;

public class ConstantPoolOOM {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        short i = 0;
        try {
            while (true) {
                set.add(String.valueOf(i++).intern());
            }
        } catch (Throwable e) {
            System.out.println("length: " + i);
            throw e;
        }
    }
}
