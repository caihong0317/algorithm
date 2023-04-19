package com.caihong.javathinking.enumtype;

import java.util.Random;

public class Enums {
    private static final Random RANDOM = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> clazz) {
        T[] values = clazz.getEnumConstants();
        return values[RANDOM.nextInt(values.length)];
    }
}
