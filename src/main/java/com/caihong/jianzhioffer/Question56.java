package com.caihong.jianzhioffer;

import java.util.Arrays;

// 数组中只出现一次的两个数字，拓展暂时不做
public class Question56 {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        Question56 q = new Question56();
        System.out.println(q.theIndexIsOne(5, 0));
        int[] ints = q.findNumsAppearOnce(nums);
        System.out.println(Arrays.toString(ints));

    }

    private boolean isValid = true;

    // 1、 找一个数
    private int findNumAppearOnce(int[] array) {
        if (array == null || array.length < 2) {
            isValid = false;
            return -1;
        }
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }

    private int[] findNumsAppearOnce(int[] array) {
        if (array == null || array.length < 2) {
            isValid = false;
            return array;
        }
        int[] nums = new int[]{0, 0};
        int tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            tmp ^= array[i];
        }
        String str = Integer.toBinaryString(tmp);
        //第一个 1 的位置
        int index = str.length() - str.lastIndexOf("1");
        for (int i = 0; i < array.length; i++) {
            if (theIndexIsOne(array[i], index)) {
                nums[0] ^= array[i];
            } else {
                nums[1] ^= array[i];
            }
        }
        return nums;
    }

    // 也可以使用移位运算
    private boolean theIndexIsOne(int i, int index) {
        String str = Integer.toBinaryString(i);
        int index1 = str.length() - index;
        // 不用if和else
        return str.length() > index1 && str.charAt(index1) == '1';
    }
}