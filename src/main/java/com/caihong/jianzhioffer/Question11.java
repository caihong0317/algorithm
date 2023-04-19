package com.caihong.jianzhioffer;

// 旋转数组中找最小
public class Question11 {
    public static void main(String[] args) {
        int[] array1={4,5,7,0,2,3,3};
        int[] array2={1,2,3,4,5,7};
        int[] array3={2,2,2,2,5,7,0,2,2};
        System.out.println(findRotatingArraysMinValue(array1));
        System.out.println(findRotatingArraysMinValue(array2));
        System.out.println(findRotatingArraysMinValue(array3));
    }

    // 要求array由升序数组旋转后得到
    public static int findRotatingArraysMinValue (int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int middle = 0;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                middle = end;
                break;
            }
            middle = (end + start) >> 1;
            if (array[middle] == array[start] && array[middle] == array[end]) {
                //全扫描查找
                return getMin(array, start, end);
            }
            if (array[middle] >= array[start]) {
                start = middle;
            }
            if (array[middle] <= array[end]) {
                end = middle;
            }
        }
        // 未旋转时array[0]最小
        return array[middle];
    }

    private static int getMin(int[] array, int start, int end) {
        int tmp = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < tmp) {
                tmp = array[i];
            }
        }
        return tmp;
    }
}