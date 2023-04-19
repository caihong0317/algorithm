package com.caihong.jianzhioffer;

import java.util.Arrays;

// 字符串中空格替换
public class Question5 {
    public static void main(String[] args) {
        char[] array1 = null;
        char[] array2 = {' ', ' ', ' '};
        char[] array3 = {'h', ' ', ' ', ' ', 'e', ' ', ' ', ' ', ' ', ' ', ' '};
        // 测试用例挺难写的
        replaceBlank(array1, 7);
        replaceBlank(array2, 7);
        replaceBlank2(array3, 5);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        //[h, %, 2, 0, %, 2, 0, %, 2, 0, e]
        System.out.println(Arrays.toString(array3));
    }

    // 使用while循环，O(n)
    public static void replaceBlank(char[] str, int length) {
        if (str == null || length > str.length) {
            return;
        }
        int blankCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                blankCount++;
            }
        }
        int newLength = length + 2 * blankCount;
        if (blankCount > 0 && newLength <= str.length) {
            while (length >= 0 && newLength > length) {
                if (str[--length] == ' ') {
                    str[--newLength] = '0';
                    str[--newLength] = '2';
                    str[--newLength] = '%';
                } else {
                    str[--newLength] = str[length];
                }
            }
        }
    }

    // 使用for循环，O(n)
    public static void replaceBlank2(char[] str, int length) {
        if (str == null || length > str.length) {
            return;
        }
        int blankCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                blankCount++;
            }
        }
        int newLength = length + 2 * blankCount;
        if (blankCount > 0 && newLength <= str.length) {
            for (int i = length - 1; i >= 0; i--) {
                if (blankCount < 0) {
                    return;
                }
                if (str[i] == ' ') {
                    str[--newLength] = '0';
                    str[--newLength] = '2';
                    str[--newLength] = '%';
                    blankCount--;
                } else {
                    str[--newLength] = str[i];
                }
            }
        }
    }
}