package com.caihong.jianzhioffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question3 {

    public static void main(String[] args) {
        // 测试，预期输出：2、-1、-1、-1
        int[] array1 = {2, 3, 1, 0, 2, 5, 3};
        int[] array2 = null;
        int[] array4 = {};
        int[] array3 = {-2, 3, 1, 0, 2, 7, 3};
        System.out.println(getDuplicateNumber1(array1));
        System.out.println(getDuplicateNumber1(array2));
        System.out.println(getDuplicateNumber1(array3));
        System.out.println(getDuplicateNumber1(array4));
    }

    // 只能找出一个，时间O(n)，空间O(1)，改变原数组
    public static int getDuplicateNumber1(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int length = array.length;
        for (int i : array) {
            if (i < 0 || i > length - 1) {
                return -1;
            }
        }

        for (int i = 0; i < length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    return array[i];
                }
                int tmp = array[array[i]];
                array[array[i]] = array[i];
                array[i] = tmp;
            }
        }
        return -1;
    }

    // 使用Hash表，时间O(n)，空间O(n)
    public static int getDuplicateNumber2(int[] array) {
        // 校验
        //
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            if (set.contains(i)) {
                return i;
            } else {
                set.add(i);
            }
        }
        return -1;
    }

    // 使用排序，时间O(nlogN+n)，空间O(1)，改变原数组
    public static int getDuplicateNumber3(int[] array) {
        // 校验
        //
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[i + 1]) {
                return array[i];
            }
        }
        return -1;
    }
}