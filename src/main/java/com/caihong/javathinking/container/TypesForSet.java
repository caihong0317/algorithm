package com.caihong.javathinking.container;

import java.util.Set;

public class TypesForSet {
    static <T> void fill(Set<T> set, Class<T> clazz) {
        try {
            for (int i = 0; i < 10; i++) {
                set.add(clazz.getConstructor(int.class).newInstance(i));
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}