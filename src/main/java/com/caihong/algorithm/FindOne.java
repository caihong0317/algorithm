package com.caihong.algorithm;

import java.util.Arrays;

public class FindOne {

    public static void main(String[] args) {
        int[] array = {1, 10, 9, 5, 20, 89, 7};
        Arrays.sort(array);
        System.out.println(indexOf(array, 5));
        System.out.println(indexOf(array, 31));
    }

    public static int indexOf(int[] array, int num) {
        if (array == null || array.length == 0) {
            return -1;
        }
        return find(array, num, 0, array.length - 1);
    }

    private static int find(int[] array, int num, int start, int end) {
        if (start == end) {
            return array[start] == num ? start : -1;
        }
        int index;
        int middle = (start + end) >> 1;
        if (num == array[middle]) {
            index = middle;
        } else if (num < array[middle]) {
            index = find(array, num, start, middle - 1);
        } else {
            index = find(array, num, middle + 1, end);
        }
        return index;
    }
}
