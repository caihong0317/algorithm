package com.caihong.jianzhioffer;

//在排序数组中查找数字
public class Question53 {

    public static void main(String[] args) {
        int num = 3;
        int[] array1 = {1, 1, 2, 2, 5, 6};
        int[] array2 = {1, 1, 2, 3, 5, 6};
        int[] array3 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getCountForNumber(null, num)); //0
        System.out.println(getCountForNumber(array1, num)); //0
        System.out.println(getCountForNumber(array2, num)); //1
        System.out.println(getCountForNumber(array3, num)); //4
    }

    // 1.O(N)
    public static int orderScan(int[] array, int number) {
        int count = 0;
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == number) {
                    count++;
                }
            }
        }
        return count;
    }

    // 2、 二分查找,O(logN)
    private static int getCountForNumber(int[] array, int number) {
        int count = 0;
        if (array != null && array.length > 0) {
            int firstK = getFirstIndexForK(array, number, 0, array.length - 1);
            int lastK = getLastIndexForK(array, number, 0, array.length - 1);
            if (firstK > -1) {
                count = lastK - firstK + 1;
            }
        }
        return count;
    }

    // 已经有序，无需使用QuickSort.partition
    private static int getFirstIndexForK(int[] array, int number, int start, int end) {
        if (array == null || array.length == 0 || start > end) {
            // 返回0不合适
            return -1;
        }
        int middle = (start + end) >> 1;
        if (array[middle] == number) {
            if (middle > 0 && array[middle] != array[middle - 1]) {
                return middle;
            } else {
                end = middle - 1;
            }
        } else if (array[middle] > number) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }
        return getFirstIndexForK(array, number, start, end);
    }

    // 已经有序，无需使用QuickSort.partition
    private static int getLastIndexForK(int[] array, int number, int start, int end) {
        if (array == null || array.length == 0 || start > end) {
            return -1;
        }
        int middle = (start + end) >> 1;
        if (array[middle] == number) {
            if (middle > 0 && array[middle] != array[middle + 1]) {
                return middle;
            } else {
                start = middle + 1;
            }
        } else if (array[middle] > number) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }
        return getLastIndexForK(array, number, start, end);
    }
}