package com.caihong.jianzhioffer;

public class Question11Receive {
    public static void main(String[] args) {
        int[] array1 = {4, 5, 7, 0, 2, 3, 3};
        int[] array3 = {2, 2, 2, 2, 5, 7, 0, 2, 2};
        System.out.println(findRotatingArraysMinValue(array1));
        System.out.println(findRotatingArraysMinValue(array3));
        int[] array2 = {1, 2, 3, 4, 5, 7};
        System.out.println(findRotatingArraysMinValue(array2));

    }

    public static int findRotatingArraysMinValue(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        if (array[start] < array[end]) {
            return array[start];
        }

        while (array[start] >= array[end]) {
            if (start - end == -1) {
                return array[end];
            }
            int middle = (start + end) >> 1;
            if (array[start] < array[middle] || array[middle] > array[end]) {
                start = middle;
            } else if (array[start] > array[middle] || array[middle] < array[end]) {
                end = middle;
            } else { // 顺序查找
                return getMin(array);
            }
        }
        return array[end];
    }

    private static int getMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
