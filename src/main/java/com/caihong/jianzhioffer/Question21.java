package com.caihong.jianzhioffer;

import com.caihong.java8action.chapter1.Predicate;

import java.util.Arrays;

public class Question21 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        move(array, Question21::isEven);
        System.out.println(Arrays.toString(array));
    }

    public static void move(int[] array, Predicate<Integer> predicate) {
        if (array == null || array.length < 2) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && !predicate.test(array[start])) {
                start++;
            }
            while (start < end && predicate.test(array[end])) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
    }

    private static boolean isEven(int number) {
        return (number & 1) == 0;
    }
}
