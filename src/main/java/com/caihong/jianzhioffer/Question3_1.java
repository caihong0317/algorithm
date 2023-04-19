package com.caihong.jianzhioffer;

public class Question3_1 {

    public static void main(String[] args) {
        // 测试，预期输出：2或3、-1、-1、-1
        int[] array1 = {2, 3, 5, 4, 3, 2, 6, 7};
        int[] array2 = null;
        int[] array4 = {};
        int[] array3 = {-2, 3, 1, 0, 2, 7, 3};
        System.out.println(getDuplicateNumber1(array1));
        System.out.println(getDuplicateNumber1(array2));
        System.out.println(getDuplicateNumber1(array3));
        System.out.println(getDuplicateNumber1(array4));
    }

    // 只能找出一个，时间O(nlogN)，空间O(1)，不改变原数组
    public static int getDuplicateNumber1(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int length = array.length;
        for (int i : array) {
            if (i < 1 || i > length - 1) {
                return -1;
            }
        }

        return duplicateNumber(array, 1, length - 1);
    }

    // 递归例程
    public static int duplicateNumber(int[] array, int left, int right) {

        int centor = (left + right) / 2;
        int leftCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= left && array[i] <= centor) {
                leftCount++;
            }
        }
        // 左半区
        if (leftCount > (centor - left + 1)) {
            if (left == centor) {
                return left;
            }
            return duplicateNumber(array, left, centor);
        } else {
            if (right - centor == 1) {
                return right;
            }
            return duplicateNumber(array, centor + 1, right);
        }
    }
}