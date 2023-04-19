package com.caihong.jianzhioffer;

// 股票的最大收益
public class Question63 {
    public static void main(String[] args) {
        int[] nums = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(getMaxYield(nums)); //11
        System.out.println(getMinYield(nums)); //-6
    }

    // 穷举法，双层for，O(n^2)


    // O(n)
    public static int getMaxYield(int[] array) {
        int result = Integer.MIN_VALUE;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i] - min;
            result = result >= tmp ? result : tmp;
            min = min > array[i] ? array[i] : min;
        }
        return result;
    }

    public static int getMinYield(int[] array) {
        int result = Integer.MAX_VALUE;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i] - min;
            result = result >= tmp ? tmp : result;
            min = min > array[i] ? min : array[i];
        }
        return result;
    }
}
