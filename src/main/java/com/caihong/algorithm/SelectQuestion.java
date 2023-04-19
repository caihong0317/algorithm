package com.caihong.algorithm;

// 集合中找第N大元素
public class SelectQuestion {

    // 全排序后返回第k个元素

    // 维护前k个元素的排序

    // 快速选择
    private static <AnyType extends Comparable<? super AnyType>> void quickSelect(AnyType[] array, int left, int right, int k) {
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
            if (k <= i) {
                quickSelect(array, left, i - 1, k);
            } else {
                quickSelect(array, i + 1, right, k);
            }
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

    private static <AnyType extends Comparable<? super AnyType>> void swap(AnyType[] array, int i, int j) {
        AnyType tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}
