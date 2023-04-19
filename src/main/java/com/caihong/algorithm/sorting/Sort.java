package com.caihong.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] array = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
//        bubbleSort(array);
//        bubbleSort1(array);
//        bubbleSort2(array);
//        selectSort2(array);
//        insertSort2(array);
        System.out.println(Arrays.toString(array));

//        selectSort(array);
//        insertSort1(array);
//        shellSort(array);
//        mergeSort(array);

//        Integer[] array1 = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
//        heapSort(array1);
//        System.out.println(Arrays.toString(array1));
//        String[] arr = {"hello", "world", "array", "aaaaa", "acdab", "abaes"};
//        radixSort1(arr, 5);
//        String[] arr = {"hello", "world", "array", "aaa", "ab", "aba", "system"};
//        radixSort2(arr, 6);
//        System.out.println(Arrays.toString(arr));
    }

    //冒泡递增排序-正向遍历，通过两两比较并交换来找最大的
    public static void bubbleSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //冒泡递增排序-反向遍历
    public static void bubbleSort2(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    //冒泡改进
    public static void bubbleSort1(int[] array) {
        int temp;
        //默认无序
        boolean flag = true;
        for (int i = 1; i < array.length && flag; i++) {
            flag = false;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    public static void selectSort(int[] array) {
        int j, min, temp;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void selectSort2(int[] array) {
        int min;
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void insertSort(int[] array) {
        int temp, j;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    public static void insertSort1(int[] array) {
        int temp, j;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    //希尔排序
    public static void shellSort(int[] array) {
        int j, temp;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                temp = array[i];
                for (j = i; j >= gap && temp < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    /**
     * mergeSort algorithm
     *
     * @param array an array of  int items
     */
    public static void mergeSort(int[] array) {
        int length = array.length;
        int[] tempArray = new int[length];
        mergeSort(array, tempArray, 0, length - 1);
    }

    /**
     * Internal method that makes recursive calls.
     *
     * @param array
     * @param tempArray
     * @param left
     * @param right
     */
    private static void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(array, tempArray, left, center);
            mergeSort(array, tempArray, center + 1, right);
            merge(array, tempArray, left, center + 1, right);
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     *
     * @param array
     * @param tempArray
     * @param leftPos
     * @param rightPos
     * @param rightEnd
     */
    private static void merge(int[] array, int[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int size = rightEnd - leftPos + 1;
        int tempPos = leftPos;

        //Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos] < array[rightPos]) {
                tempArray[tempPos++] = array[leftPos++];
            } else {
                tempArray[tempPos++] = array[rightPos++];
            }
        }
        //Copy rest of left half
        while (leftPos <= leftEnd) {
            tempArray[tempPos++] = array[leftPos++];
        }
        //Copy rest of right half
        while (rightPos <= rightEnd) {
            tempArray[tempPos++] = array[rightPos++];
        }
        //Copy tempArray back
        for (int i = 0; i < size; i++) {
            array[rightEnd] = tempArray[rightEnd];
            rightEnd--;
        }
    }

    // 堆排序, index从0开始, 最小堆将降序排序，反之最大堆将升序
    public static <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType[] array) {
        // 建Max堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolateDown(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        // i=0时，array已经排序完
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            percolateDown(array, 0, i);
        }
    }

    // 交换元素
    private static <AnyType extends Comparable<? super AnyType>> void swap(AnyType[] array, int i, int j) {
        AnyType tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // 建Max堆
    private static <AnyType extends Comparable<? super AnyType>> void percolateDown(AnyType[] array, int i, int length) {
        int child;
        AnyType tmp = array[i];
        for (; leftChild(i) < length; i = child) {
            child = leftChild(i);
            if (child != length - 1 && array[child].compareTo(array[child + 1]) < 0) {
                child++;
            }
            if (tmp.compareTo(array[child]) < 0) {
                array[i] = array[child];
            } else {
                break;
            }
        }
        array[i] = tmp;
    }

    // 此方法可以不必有
    private static int leftChild(int i) {
        return i * 2 + 1;
    }

    // quickSort start
    // 原始的quickSort
    public static <AnyType extends Comparable<? super AnyType>> void quickSort1(List<AnyType> list) {
        final int cutoff = 10;
        // 采用quickSort
        if (list.size() > 10) {
            List<AnyType> smaller = new ArrayList<>();
            List<AnyType> same = new ArrayList<>();
            List<AnyType> larger = new ArrayList<>();

            AnyType center = list.get(list.size() / 2);
            for (AnyType item : list) {
                if (item.compareTo(center) < 0) {
                    smaller.add(item);
                } else if (item.compareTo(center) > 0) {
                    larger.add(item);
                } else {
                    same.add(item);
                }
            }

            quickSort1(smaller);
            quickSort1(larger);

            list.clear();
            list.addAll(smaller);
            list.addAll(same);
            list.addAll(larger);
        }

        // 采用insert sort

    }

    public static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] array, int left, int right) {
        final int cutoff = 10;
        // 采用quickSort
        if (left + cutoff <= right) {
            AnyType pivot = medianThree(array, left, right);
            int i = left, j = right - 1;
            for (; ; ) {
                while (array[++i].compareTo(pivot) < 0) {
                }
                while (array[--j].compareTo(pivot) > 0) {
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
            // 采用insert sort

        }
    }

    private static <AnyType extends Comparable<? super AnyType>> AnyType medianThree(AnyType[] array, int left, int right) {
        int center = (left + right) / 2;
        // 3数排序
        if (array[center].compareTo(array[left]) < 0) {
            swap(array, center, left);
        }
        if (array[right].compareTo(array[left]) < 0) {
            swap(array, right, left);
        }
        if (array[right].compareTo(array[center]) < 0) {
            swap(array, right, center);
        }
        // 将pivot放到right-1
        swap(array, center, right - 1);
        return array[right - 1];
    }
    // quickSort end

    // bucketSort
    // 长度相等的字符串排序
    public static void radixSort1(String[] array, int strLen) {
        final int BUCKET_NUM = 256;
        ArrayList[] buckets = new ArrayList[BUCKET_NUM];
        // 此处不能用增for
/*        for (ArrayList bucket : buckets) {
            bucket = new ArrayList<String>();
        }*/

        for (int i = 0; i < BUCKET_NUM; i++) {
            buckets[i] = new ArrayList<String>();
        }

        for (int pos = strLen - 1; pos >= 0; pos--) {
            for (String str : array) {
                buckets[str.charAt(pos)].add(str);
            }
            // 回写
            int index = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String str : bucket) {
                    array[index++] = str;
                }
                bucket.clear();
            }
        }
    }

    // bucketSort
    // 不定长的字符串排序
    public static void radixSort2(String[] array, int maxLen) {
        final int BUCKET_NUM = 256;
        ArrayList<String>[] lenBuckets = new ArrayList[maxLen + 1];
        ArrayList<String>[] buckets = new ArrayList[BUCKET_NUM];

        for (int i = 0; i < maxLen + 1; i++) {
            lenBuckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < BUCKET_NUM; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 按长度分桶
        for (String str : array) {
            lenBuckets[str.length()].add(str);
        }
        // 放回
        int index = 0;
        for (ArrayList<String> lenBucket : lenBuckets) {
            for (String str : lenBucket) {
                array[index++] = str;
            }
        }

        int startIndex = array.length;
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            startIndex -= lenBuckets[pos + 1].size();
            for (int i = startIndex; i < array.length; i++) {
                buckets[array[i].charAt(pos)].add(array[i]);
            }
            // 放回,可新声明一个int,而不复用index
            index = startIndex;
            for (ArrayList<String> bucket : buckets) {
                for (String str : bucket) {
                    array[index++] = str;
                }
                bucket.clear();
            }
        }
    }

}
