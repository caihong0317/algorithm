package com.caihong.algorithm;

public class LogNExample {

    private static final int NOT_FIND = -1;

    public static void main(String[] args) {
        int num = gcd(1989, 1590);
        System.out.println(num);
    }

    // binary search ,数组已经升序排序，未找到时返回-1
    public static <AnyType extends Comparable<? super AnyType>> int contains(AnyType[] array, AnyType x) {
        int low = 0, high = array.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (array[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return NOT_FIND;
    }

    // 最大公约数，O(logN)
    public static int gcd(int m, int n) {
        int rem = 0;
        while (n != 0) {
            rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    // 递归求x^n
    public static long pow(long x, int n){
        if (n==0) {
            return 1;
        }
        // 此判断可不需要
        if (n==1) {
            return x;
        }

        if (n%2==0) {
            return pow(x*x,n/2);
        }else {
            return pow(x*x,n/2)*x;
        }
    }
}
