package com.caihong.algorithm;

import java.util.Scanner;

public class Rabbit {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int i = scanner.nextInt();
        System.out.println(calculatePI(i));
    }

    public boolean chichen(int head, int foot) {
        int chichen;
        int rabbit;
        for (int i = 1; i <= head; i++) {
            int j = head - i;
            if (i * 2 + j * 4 == foot) {
                chichen = i;
                rabbit = j;
                return true;
            }
        }
        return false;
    }

    public int fibonacci(int mouth) {
        if (mouth == 1 || mouth == 2) {
            return 1;
        }
        return fibonacci(mouth - 1) + fibonacci(mouth - 2);
    }

    //分治
    public int falseCoin(int[] coins, int start, int end) {
        int result;
        int sum1 = 0;
        int sum2 = 0;
        //结束条件,只剩两个硬币时
        if (end - start == 1) {
            if (coins[start] < coins[end]) {
                result = start + 1;
            } else {
                result = end + 1;
            }
        }
        //为奇数个时
        if ((end - start + 1) / 2 != 0) {
            for (int i = start; i <= start + (end - start) / 2 - 1; i++) {
                sum1 = sum1 + coins[i];
            }
            for (int i = start + (end - start) / 2 + 1; i <= end; i++) {
                sum2 = sum2 + coins[i];
            }
            if (sum1 < sum2) {
                result = falseCoin(coins, start, start + (end - start) / 2 - 1);
            } else if (sum1 > sum2) {
                result = falseCoin(coins, start + (end - start) / 2 + 1, end);
            } else {
                //当有且仅有一个假币时
                result = start + (end - start) / 2;
            }
        } else {
            for (int i = start; i <= start + (end - start) / 2; i++) {
                sum1 = sum1 + coins[i];
            }
            for (int i = start + (end - start) / 2 + 1; i <= end; i++) {
                sum2 = sum2 + coins[i];
            }
            if (sum1 < sum2) {
                result = falseCoin(coins, start, start + (end - start) / 2);
            } else {
                result = falseCoin(coins, start + (end - start) / 2 + 1, end);
            }
        }
        return result;
    }

    //计算PI
    public static double calculatePI(int n) {
        double x, y, pi;
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            x = Math.random();
            y = Math.random();
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                sum++;
            }
        }
        pi = 4 * sum / n;
        return pi;
    }


}
