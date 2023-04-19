package com.caihong.jianzhioffer;

//0~n-1中缺失的数字
public class Question53_1 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array3 = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10};
        int[] array4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(getMissingNumber2(null, 0, 5)); //-1
        System.out.println(getMissingNumber2(array1, 0, array1.length - 1)); //0
        System.out.println(getMissingNumber2(array2, 0, array1.length - 1)); //10
        System.out.println(getMissingNumber2(array3, 0, array1.length - 1)); //5
        System.out.println(getMissingNumber2(array4, 0, array1.length - 1)); //-1
    }

    // 1、O(N)，-1表示没有找到
    public static int getMissingNumber(int[] array) {
        int num = -1;
        if (array != null && array.length > 0) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] - array[i - 1] == 2) {
                    num = array[i] - 1;
                }
            }
        }
        return num;
    }

    // 2、 二分查找,O(logN),边界条件不好写，可用循环而不用递归
    private static int getMissingNumber2(int[] array, int start, int end) {
        if (array == null || array.length == 0 || start > end) {
            return -1;
        }
        int middle = (start + end) >> 1;
        if (array[middle] == middle) {
            if (middle < array.length - 1 && array[middle + 1] != middle + 1 || middle == array.length - 1) {
                return array[middle] + 1;
            } else {
                start = middle + 1;
            }
        } else {
            if (middle > 0 && array[middle - 1] == middle - 1 || middle == 0) {
                return array[middle] - 1;
            } else {
                end = middle - 1;
            }
        }
        return getMissingNumber2(array, start, end);
    }
}