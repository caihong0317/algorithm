package com.caihong.algorithm;

import java.util.Arrays;

//斐波那些数列
public class Fabonacci {

    public static void main(String[] args) {
/*        int i = 0;
        long start = System.currentTimeMillis();
//        i = fib(40);//537、516ms
//        i = fib2(40); //0
//        i = fib3(40);//0
        i = fib4(40);//0
        long end = System.currentTimeMillis();
        System.out.println(i); //102334155
        System.out.println(end - start);*/

        // 数组需定长
        int[] ints = new int[10];
        int length = ints.length;
        for (int i = 0; i < length; i++) {
            ints[i]=i;
        }
        System.out.println(length);
        System.out.println(Arrays.toString(ints));
    }

    //递归O(5/3)^n
    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //迭代O(4n)
    public static int fib2(int n) {
        int a, b, c;
        a = b = c = 1;
        if (n <= 2) {
            return 1;
        }

        int i = 3;
        while (i <= n) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        return c;
    }

    //数组O(3n)
    public static int fib3(int n) {
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    //改进数组，减少空间消耗，O(6n)
    public static int fib4(int n) {
        int[] array = new int[3];
        array[1] = array[2] = 1;
        int index = 1;
        for (int i = 3; i <= n; i++) {
            index = i % 3;
            if (index == 0) {
                array[index] = array[1] + array[2];
            } else if (index == 1) {
                array[index] = array[0] + array[2];
            } else {
                array[index] = array[0] + array[1];
            }
        }
        return array[index];
    }
}
