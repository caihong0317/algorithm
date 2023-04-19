package com.caihong.jianzhioffer;

//1~n中1出现的次数
public class Question43 {

    public static void main(String[] args) {
        System.out.println(countOneForOneToN(99)); //20
        System.out.println(countOneForOneToN(0)); //0
        System.out.println(countOneForOneToN(10)); //2
    }

    // 穷举法，O(nlogn)
    public static int countOneForOneToN(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += countOne(i);
        }
        return count;
    }

    private static int countOne(int num) {
        if (num <= 0) {
            return 0;
        }
        int count = 0;
        while (num > 0) {
            if (num % 10 == 1) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
