package com.caihong.jianzhioffer;

public class Question15 {

    public static void main(String[] args) {
/*
        System.out.println(countOne(10)); // 2
        System.out.println(countOne2(10)); // 2
*/
        System.out.println(is2Pow(10));
        System.out.println(is2Pow(128));
    }

    public static int countOne(int number) {
        int count = 0;
        while (number > 0) {
            int i = number & 1;
            if (i == 1) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

    public static int countOne2(int number) {
        int count = 0;
        int start = 1;
        while (start < number) {
            int i = number & start;
            if (i == start) {
                count++;
            }
            start = start << 1;
        }
        return count;
    }

    public static boolean is2Pow(int number) {
        return (number & (number - 1)) == 0;
    }
}