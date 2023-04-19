package com.caihong.jianzhioffer;

//数组中数值和下标相等的元素
public class Question53_2 {

    public static void main(String[] args) {
        int[] array1 = {-3, -1, 1, 3, 5, 6};
        int[] array2 = {-3, -1, 1, 2, 5, 6};
//        System.out.println(orderScan(array1)); //3
//        System.out.println(findNumber(array1, 0, array1.length - 1)); //3
        System.out.println(findNumber2(array1)); //-1
        System.out.println(findNumber2(array2)); //-1
    }

    // 1、O(N)，-1表示没有找到
    public static int orderScan(int[] array) {
        int num = -1;
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == i) {
                    num = array[i];
                    break;
                }
            }
        }
        return num;
    }

    // 2、 二分查找,O(logN),边界条件不好写，可用循环而不用递归
    private static int findNumber(int[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int middle = 0;
        while (start <= end) {
            middle = (start + end) >> 1;
            if (middle == array[middle]) {
                return array[middle];
            } else if (middle < array[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private static int findNumber2(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int middle;
        while (start <= end) {
            middle = (start + end) >> 1;
            if (array[middle] == middle) {
                return middle;
            } else if (array[middle] > middle) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}