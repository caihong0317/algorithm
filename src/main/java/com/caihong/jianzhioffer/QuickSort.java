package com.caihong.jianzhioffer;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {4, 2, 7, 8, 5};
        int mid = array.length >> 1;
        swapThree(array, 0, array.length - 1, mid);
        System.out.println(Arrays.toString(array));
    }

    //快速排序
    public static void quickSort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int index = partition(array, start, end);
        if (index > start) {
            quickSort(array, start, index - 1);
        }
        if (index < end) {
            quickSort(array, index + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        if (array == null || start > end || start < 0 || end >= array.length) {
            return -1;
        }
        int middle = (start + end) >> 1;
        swapThree(array, start, end, middle);
        int small = start - 1;
        int index;
        for (index = start; index < end; index++) {
            if (array[index] < array[end]) {
                small++;
                if (small != index) {
                    // 此处small不再加1
                    swapTwo(array, small, index);
                }
            }
        }
        small++;
        swapTwo(array, small, end);
        return small;
    }

    // 将中值放最后，并不需要排序
    private static void swapThree(int[] array, int start, int end, int middle) {
        // 与其交换，不如排序后赋值
        if (array[start] > array[middle]) {
            if (array[start] < array[end]) {
                //start为中值
                swapTwo(array, start, end);
            }
            if (array[middle] > array[end]) {
                // middle为中值
                swapTwo(array, middle, end);
            }
        } else {
            if (array[middle] < array[end]) {
                //middle为中值
                swapTwo(array, middle, end);
            }
            if (array[start] > array[end]) {
                // start为中值
                swapTwo(array, start, end);
            }
        }
    }

    public static void swapTwo(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}