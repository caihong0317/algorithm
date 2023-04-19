package com.caihong.jianzhioffer;

import static com.caihong.jianzhioffer.Question16.power;

//对应1版12题;写这段代码出了3个错
// 大数问题
public class Question17 {

    public static void main(String[] args) {
        printToMaxOfDigits(3);
    }

    public static void printToMaxOfDigits(int digit) {
        if (digit <= 0) {
            return;
        }
        char[] chars = new char[digit];
        for (int i = 0; i < digit; i++) {
            chars[i] = '0';
        }
        while (!increment(chars, digit)) {
            printChars(chars);
        }
    }

    // O(1)
    private static boolean increment(char[] chars, int digit) {
        boolean isOverFlow = false;
        int takeOver = 0;
        // 从右到左逐位处理
        for (int i = digit - 1; i >= 0; i--) {
            int num = chars[i] - '0' + takeOver;
            //个位加1
            if (i == digit - 1) {
                num++;
            }
            if (num >= 10) {
                // 最高位进位时结束
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    takeOver = 1;
                    num -= 10;
                    chars[i] = (char) ('0' + num);
                }
            } else {
                chars[i] = (char) ('0' + num);
                break;
            }
        }
        return isOverFlow;
    }

    private static void printChars(char[] chars) {
        boolean isNotPrint = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                isNotPrint = false;
            }
            if (!isNotPrint) {
                System.out.print(chars[i]);
            }
        }
        System.out.println();
    }
}