package com.caihong.jianzhioffer;

import java.util.Stack;

// 两个栈实现队列
public class Question10 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(sumN(10000)); //2
        System.out.println(sumN2(10000)); //1
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int sumN(int n) {
        return n <= 0 ? 0 : n + sumN(n - 1);
    }

    public static int sumN2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

}