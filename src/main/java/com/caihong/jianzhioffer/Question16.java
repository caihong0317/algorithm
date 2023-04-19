package com.caihong.jianzhioffer;

// 考查鲁棒性
public class Question16 {
    private static boolean SUCCESS = true;

    public static void main(String[] args) {
        System.out.println(power(-2.5, 3));
        System.out.println(power(2.5, 0));
        System.out.println(power(2.5, -3));
        System.out.println(power(0, -3));
    }

    public static double power(double base, int exponent) {
        double result = 0.0;
        if (base == 0.0 && exponent <= 0) {
            SUCCESS = false;
            return result;
        }
        int tmp = exponent;
        if (exponent < 0) {
            tmp = -exponent;
        }
        result = doPower(base, tmp);
        if (exponent < 0) {
            result = 1 / result;
        }
        SUCCESS = true;
        return result;
    }

    // O(n)
    private static double doPower(double base, int exponent) {
        double result = 1.0;
        if (exponent != 0) {
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }
        }
        return result;
    }

    // O(logn)
    private static double doPower2(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent == 1) {
            return base;
        }
        double result = doPower2(base, exponent >> 1);
        result *= result;
        if (exponent % 2 == 1) {
            result *= base;
        }
        return result;
    }
}