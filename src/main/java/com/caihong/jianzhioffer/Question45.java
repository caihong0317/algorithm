package com.caihong.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

//把数组排成最小的数（大数问题）
public class Question45 {

    public static void main(String[] args) {
        int[] array1 = null;
        int[] array2 = {3};
        int[] array3 = {3, 32, 321};
        System.out.println(permutation(array1)); //-1
        System.out.println(permutation(array2)); //3
        System.out.println(permutation(array3)); //321323
    }

    // 1.采用全排序，O(n!)
    public static int permutation(int[] array) {
        if (array == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        if (array.length == 1) {
            return array[0];
        } else {
            permutation(array, 0, list);
            int min = list.get(0);
            for (Integer num : list) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        }
    }

    // 获取数组的全排列
    private static void permutation(int[] array, int index, List<Integer> list) {
        if (index == array.length - 1) {
            list.add(convertArrayToNumber(array));
        }
        int tmp;
        for (int i = index; i < array.length; i++) {
            // 交换（包含和自身）
            tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
            permutation(array, index + 1, list);

            //还原首位元素
            array[i] = array[index];
            array[index] = tmp;
        }
    }

    private static int convertArrayToNumber(int[] array) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            buffer.append(array[i]);
        }
        return Integer.parseInt(buffer.toString());
    }

    // 2.将数组排序，O(nlogn)
    public static int getTheNumber(int n) {
        if (n < 0) {
            return -1;
        }
        int count = 0;
        int num = 0;
        while (count < n) {
            count += getDigit(num);
            num++;
        }
        num -= 1;
        int index = count - n;
        int digit = 0;
        // 不好找
        while (digit < index) {
            num /= 10;
            digit++;
        }
        return num % 10;
    }

    // 求数字位数
    private static int getDigit(int num) {
        if (num == 0) {
            return 0;
        }
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}