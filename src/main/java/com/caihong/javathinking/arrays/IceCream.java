package com.caihong.javathinking.arrays;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static final Random RANDOM = new Random(47);
    private static final String[] flavors = {"A", "B", "C", "D", "E", "F", "G"};

    public static String[] setFlavor(int n) {
        int length = flavors.length;
        if (n < 0 || n > length) {
            throw new RuntimeException("too many");
        }
        String[] result = new String[n];
        boolean[] flags = new boolean[length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = RANDOM.nextInt(length);
            } while (flags[t]);
            result[i] = flavors[t];
            flags[t] = true;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            String[] flavor = setFlavor(4);
            System.out.println(Arrays.toString(flavor));
        }
    }
}