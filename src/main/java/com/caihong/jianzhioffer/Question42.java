package com.caihong.jianzhioffer;

import java.util.List;

// 数组中连续子数组的最大和
public class Question42 {
    public static void main(String[] args) {
        int[] array1 = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] array2 = new int[]{};
        int[] array3 = {-3};
        System.out.println(getMaxSumForSubArray1(array1) + " " + isValid);  // 18
        System.out.println(getMaxSumForSubArray1(array2) + " " + isValid);  // 0 false
        System.out.println(getMaxSumForSubArray1(array3) + " " + isValid);  //-3 true

    }

    private static boolean isValid = true;

    // 1.使用规律，O(n)
    public static int getMaxSumForSubArray1(int[] array) {
        if (!isValidInput(array)) {
            return 0;
        }
        int maxSum = array[0];
        int thisSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (thisSum <= 0) {
                thisSum = array[i];
            } else {
                thisSum += array[i];
            }
            if (maxSum < thisSum) {
                maxSum = thisSum;
            }
        }
        return maxSum;
    }


    // 2.分治法，分左右中三段，O(nlogn)
    public static int getMaxSumForSubArray2(int[] array) {
        return 0;
    }

    public static boolean isValidInput(int[] array) {
        if (array == null || array.length == 0) {
            isValid = false;
            return false;
        }
        isValid = true;
        return true;
    }
}