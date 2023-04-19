package com.caihong.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// 数组前k个小的数
public class Question40 {
    public static void main(String[] args) {
        int[] array = {7, 4, 3, 9, 5, 8, 1, 6, 2, 10};
//        System.out.println(getLeastNumber1(array, 4).toString());  //[1, 2, 3, 4]
//        System.out.println(getLeastNumber2(array, 4).toString());  //[2, 3, 1, 4]
        System.out.println(getLeastNumber3(array, 4).toString());  //[4, 2, 3, 1]

    }

    // 1.使用快排，输出前k个，O(nlogn)
    public static List<Integer> getLeastNumber1(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        if (!isValidInput(array, k)) {
            return result;
        }
        QuickSort.quickSort(array, 0, array.length - 1);
        for (int i = 0; i < k; i++) {
            result.add(array[i]);
        }
        return result;
    }

    // 2.使用快排基础，找出第k小的数的index，O(n)
    public static List<Integer> getLeastNumber2(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        if (!isValidInput(array, k)) {
            return result;
        }
        int index = QuickSort.partition(array, 0, array.length - 1);
        while (index + 1 != k) {
            if (index + 1 > k) {
                index = QuickSort.partition(array, 0, index - 1);
            } else {
                index = QuickSort.partition(array, index + 1, array.length - 1);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(array[i]);
        }
        return result;
    }

    // 3.使用最大堆，O(nlogk)，联机算法，不改变原数组
    public static List<Integer> getLeastNumber3(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        if (!isValidInput(array, k)) {
            return result;
        }
/*        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });*/
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                queue.add(array[i]);
            } else {
                if (array[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(array[i]);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public static boolean isValidInput(int[] array, int k) {
        if (array == null || array.length == 0 || k < 0 || k > array.length) {
            return false;
        }
        return true;
    }


}