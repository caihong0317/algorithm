package com.caihong.jianzhioffer;

import java.util.Arrays;

public class Question17Review {
    public static void main(String[] args) {
        printToMaxOfDigits(3);
    }

    // 并非一开始就用字符串表示，可以从超过最大long时开始
    public static void printToMaxOfDigits(int digit) {
        if (digit <= 0) {
            return;
        }
        char[] chars = new char[digit];
        Arrays.fill(chars, '0');
        while (!increment(chars, digit)) {
            printOut(chars);
        }
    }

    private static boolean increment(char[] chars, int digit) {
        boolean isOver = false;
        int takeIn = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int num = chars[i] - '0' + takeIn;
            // 只在个位加1
            if (i == chars.length - 1) {
                num++;
            }
            if (num == 10) {
                if (i == 0) {
                    isOver = true;
                } else {
                    takeIn = 1;
                    chars[i] = '0';
                }
            } else {
                chars[i] = (char) ('0' + num);
                break;
            }
        }
        return isOver;
    }

    private static void printOut(char[] chars) {
        boolean startPrint = false;
        for (char aChar : chars) {
            if (!startPrint && aChar != '0') {
                startPrint = true;
            }
            if (startPrint) {
                System.out.print(aChar);
            }
        }
        System.out.println();
    }
}
