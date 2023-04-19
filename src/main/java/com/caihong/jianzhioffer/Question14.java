package com.caihong.jianzhioffer;

public class Question14 {

    public static void main(String[] args) {
//        System.out.println(maxAfterCut(8)); // 18
        System.out.println(maxAfterCut2(8)); // 18
    }

    public static int maxAfterCut(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int[] temp = new int[length + 1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        temp[3] = 3;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int pro = temp[j] * temp[i - j];
                if (pro > max) {
                    max = pro;
                }
            }
            temp[i] = max;
        }
        return temp[length];
    }

    public static int maxAfterCut2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int time3 = length / 3;
        int time2 = 0;
        int i = length - time3 * 3;
        if (i == 1) {
            time2 = 2;
            time3--;
        } else if (i == 2) {
            time2 = 1;
        }
        return (int) (Math.pow(3, time3) * Math.pow(2, time2));
    }
}