package com.caihong.algorithmreview;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = {4, -3, 5, -2, -1, 2, 6, -2};  //11
//        System.out.println(maxSub1(array));
//        System.out.println(maxSub2(array));
        System.out.println(maxSub3(array));
    }

    // N^3，确实不易理解
    public static int maxSub1(int[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) { // 累和
                    thisSum += array[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSub2(int[] array) {
        int maxSum = 0;
        for (int j = 0; j < array.length; j++) {
            int thisSum = 0;
            for (int k = j; k < array.length; k++) { // 累和
                thisSum += array[k];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSub3(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int thisSum = 0;
        for (int value : array) {
            thisSum += value;
            if (maxSum < thisSum) {
                maxSum = thisSum;
            }
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
