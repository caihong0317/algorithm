package com.caihong.algorithmreview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] array = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
//        insertSort(array);
//        insertSort(array, 5, array.length - 1);
//        mergeSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
/*
        List<Integer> array = Arrays.asList(81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15);
        List<Integer> list = new ArrayList<>(array);
        simpleQuickSort(list);
        System.out.println(list);
*/
    }

    // 驱动
    public static void mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int start, int end) {
        if (start < end) {
            int middle = (start + end) >> 1;
            mergeSort(array, temp, start, middle);
            mergeSort(array, temp, middle + 1, end);
            merge(array, temp, start, middle + 1, end);
        }
    }

    private static void merge(int[] array, int[] temp, int leftPos, int rightPos, int rightEnd) {
        int size = rightEnd - leftPos + 1;
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos] <= array[rightPos]) {
                temp[tempPos++] = array[leftPos++];
            } else {
                temp[tempPos++] = array[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            temp[tempPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            temp[tempPos++] = array[rightPos++];
        }

        for (int i = 0; i < size; i++, rightEnd--) { // rightEnd尚未被改变
            array[rightEnd] = temp[rightEnd];
        }
    }

    public static void simpleQuickSort(List<Integer> list) {
        if (list.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();
            Integer choose = list.get(list.size() >> 1);
            for (int i : list) {
                if (i < choose) {
                    smaller.add(i);
                } else if (i > choose) {
                    larger.add(i);
                } else {
                    same.add(i);
                }
            }
            simpleQuickSort(smaller);
            simpleQuickSort(larger);

            list.clear();
            list.addAll(smaller);
            list.addAll(same);
            list.addAll(larger);
        }
    }

    private static final int CUT_OFF = 8;

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left + CUT_OFF <= right) {
            int pivot = median3(array, left, right);
            int i = left;
            int j = right - 1;
            while (true) {
                while (array[++i] < pivot) {
                }
                while (array[--j] > pivot) {
                }
                if (i < j) {
                    swap(array, i, j);
                } else {
                    break;
                }
            }
            swap(array, i, right - 1);
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        } else {
            insertSort(array, left, right);
        }
    }

    private static int median3(int[] array, int left, int right) {
        int middle = (left + right) >> 1;
        if (array[left] > array[middle]) {
            swap(array, left, middle);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[middle] > array[right]) {
            swap(array, middle, right);
        }
        swap(array, middle, right - 1);
        return array[right - 1];
    }

    private static void swap(int[] array, int one, int other) {
        int temp = array[one];
        array[one] = array[other];
        array[other] = temp;
    }

    public static void insertSort(int[] array) {
        insertSort(array, 0, array.length - 1);
    }

    private static void insertSort(int[] array, int left, int right) {
        int j;
        int temp;
        for (int i = left + 1; i <= right; i++) {
            temp = array[i];
            for (j = i; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            if (j != i) {
                array[j] = temp;
            }
        }
    }
}
