package com.caihong.javathinking.arrays;

import java.util.Arrays;

public class GeneratorTest {

    public static void main(String[] args) {
        testGenerator(CountingGenerator.class, 5);
    }

    public static void testGenerator(Class<?> clazz, int length) {
        if (length <= 0) {
            return;
        }
        Class<?>[] classes = clazz.getClasses();
        for (Class<?> aClass : classes) {
            System.out.print(aClass.getSimpleName() + ": ");
            try {
                Generator<?> generator = (Generator<?>) aClass.newInstance();
                Object[] array = new Object[length];
                for (int i = 0; i < length; i++) {
                    array[i] = generator.next();
                }
                System.out.println(Arrays.toString(array));
            } catch (Exception e) {

            }
        }
    }
}