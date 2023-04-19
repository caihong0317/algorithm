package com.caihong.jianzhioffer;

import java.util.Arrays;

// 和为s的两个数字
public class Question57 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 11, 15};
        int[] a = findNumsToSum1(null, 12);//null
        System.out.println(Arrays.toString(a));
        int[] b = findNumsToSum1(nums, 12);
        System.out.println(Arrays.toString(b));

        int[] ints = findNumsToSum1(nums, 15);
        System.out.println(Arrays.toString(ints));
        int[] ints2 = findNumsToSum2(nums, 15);
        System.out.println(Arrays.toString(ints2));

    }

    // 1、 穷举法（无论数组是否已排序），O(n^2)
    public static int[] findNumsToSum1(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return null;
        }
        int[] result = new int[]{0, 0};
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (sum - array[i] == array[j]) {
                    result[0] = array[i];
                    result[1] = array[j];
                    return result;
                }
            }
        }
        return result;
    }

    // 2、数组已排序时，采用首尾双指针向中间合拢，O(n)
    public static int[] findNumsToSum2(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return null;
        }
        int[] result = new int[]{0, 0};

        for (int i = 0, j = array.length - 1; i < j; ) {
            if (array[i] + array[j] < sum) {
                i++;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                result[0] = array[i];
                result[1] = array[j];
                break;
            }
        }
        return result;
    }

    // 和为s的连续整数序列
    //todo
}