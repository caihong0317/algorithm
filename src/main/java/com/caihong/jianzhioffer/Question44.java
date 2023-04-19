package com.caihong.jianzhioffer;

//数字序列中某一位数字
public class Question44 {

    public static void main(String[] args) {
//        System.out.println(getTheNumber(5)); //5
//        System.out.println(getTheNumber(13)); //1
//        System.out.println(getTheNumber(1001)); //7
        System.out.println(getTheNumber2(5)); //5
        System.out.println(getTheNumber2(13)); //1
        System.out.println(getTheNumber2(1001)); //7
    }

    // 扫描，O(n)
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

    // 更快的方法，O(n)？
    public static int getTheNumber2(int n) {
        if (n < 0) {
            return -1;
        }
        int digit = 1;
        int count;
        while (true) {
            count = countOfNumberForDigit(digit);
            if (n < count * digit) {
                // 忘记写return
                return digitAtIndex(n, digit);
            }
            n -= count * digit;
            digit++;
        }
    }

    private static int digitAtIndex(int n, int digit) {
        int start = 0;
        if (digit > 1) {
            start = (int) Math.pow(10, digit - 1);
        }
        int index = digit - n % digit;
        int num = start + n / digit;
        for (int j = 1; j < index; j++) {
            num /= 10;
        }
        return num % 10;
    }

    private static int countOfNumberForDigit(int digit) {
        if (digit == 1) {
            return 10;
        }
        int count = (int) Math.pow(10, digit - 1);
        return count * 9;
    }
}