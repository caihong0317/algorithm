package com.caihong.jianzhioffer;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Arrays;

public class Question5_1 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
        int[] array2 = {2, 4, 6, 8, 10};
        mergeSortArray(array1, array2, 5, "asc");
        System.out.println(Arrays.toString(array1));
    }

    // array1有足够空间来合并,两数组同序
    //todo
    public static void mergeSortArray(int[] array1, int[] array2, int len, String sortType) {
        if (array1 == null || array2 == null) {
            return;
        }
        if (array1.length - len < array2.length) {
            System.out.println("array1空间不足");
        }
        int tail = len + array2.length - 1;
        int k = array2.length - 1;
        for (int j = len - 1; j >= 0 && k >= 0; ) {
            if ("asc".equalsIgnoreCase(sortType)) {
                if (array1[j] >= array2[k]) {
                    array1[tail--] = array1[j--];
                    if (j == 0 && k > 0) {
                        System.arraycopy(array2, 0, array1, 0, k + 1);
                    }
                    break;
                } else {
                    array1[tail--] = array2[k--];
                    if (k < 0) {
                        break;
                    }
                }
            } else {
                if (array1[j] <= array2[k]) {
                    array1[tail--] = array1[j];
                    break;
                } else {
                    array1[tail--] = array2[k];
                }
            }
        }
    }
}
