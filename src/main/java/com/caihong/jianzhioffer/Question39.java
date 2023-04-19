package com.caihong.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

// 数组中出现次数超过一半的数字
public class Question39 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 6, 6, 6, 6, 6, 6};
        System.out.println(findMostTimeNumber1(array));  //6
        System.out.println(findMostTimeNumber2(array)); //6
        System.out.println(findMostTimeNumber3(array)); //6
        System.out.println(findMostTimeNumber4(array)); //6
    }

    // 1.使用map，边扫描边判断，不改变输入数组，使用额外空间O(n)，时间O(n)
    public static Integer findMostTimeNumber1(int[] array) {
        if (!isValidArray(array)) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 使用普通for较好
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                Integer times = map.get(array[i]) + 1;
                // 至少扫描过半才去判断
                if (i * 2 > array.length && times * 2 > array.length) {
                    return array[i];
                }
                map.put(array[i], times);
            } else {
                map.put(array[i], 1);
            }
        }
        return null;
    }

    // 2.排序后取中位数，改变输入数组，不使用额外空间，时间O(nlgn+n)
    public static Integer findMostTimeNumber2(int[] array) {
        if (!isValidArray(array)) {
            return null;
        }
        QuickSort.quickSort(array, 0, array.length - 1);
/*    int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                times++;
            } else {
                // 至少扫描过半
                if (i * 2 > array.length && times * 2 > array.length) {
                    return array[i - 1];
                }
                times = 1;
            }
        }*/

        // 取中位数
        int num = array[array.length >> 1];
        if (isPresentMoreHalf(array, num)) {
            return num;
        }
        return null;
    }

    // 3.找中位数，即第n/2大的数，改变输入数组，时间O(n)
    public static Integer findMostTimeNumber3(int[] array) {
        if (!isValidArray(array)) {
            return null;
        }
        int middle = array.length >> 1;
        int index = QuickSort.partition(array, 0, array.length - 1);
        while (index != middle) {
            if (index > middle) {
                index = QuickSort.partition(array, 0, index - 1);
            } else {
                index = QuickSort.partition(array, index + 1, array.length - 1);
            }
        }
        int num = array[middle];
        if (isPresentMoreHalf(array, num)) {
            return num;
        }
        return null;
    }

    // 4.简洁方法，不变输入数组，时间O(n)
    public static Integer findMostTimeNumber4(int[] array) {
        if (!isValidArray(array)) {
            return null;
        }
        int times = 1;
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == num) {
                times++;
            } else if (times == 0) {
                times = 1;
                num = array[i];
            } else {
                times--;
            }
        }
        if (isPresentMoreHalf(array, num)) {
            return num;
        }
        return null;
    }

    public static boolean isValidArray(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return true;
    }

    public static boolean isPresentMoreHalf(int[] array, int number) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                times++;
            }
        }
        if (times * 2 > array.length) {
            return true;
        }
        return false;
    }
}