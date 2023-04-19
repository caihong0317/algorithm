package com.caihong.performance;

public class DoTest {
    private int a;
    private static int b;

    public void test() {
        a = 1;
        b = 1;
    }

    public static void main(String[] args) {
//        a=1;
        b = 1;
        testFibnax(3);
    }

    public static void testFibnax(int time) {
        double l = 0;
        long then = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            l = fibImpl(50);
        }
        long now = System.currentTimeMillis();
        System.out.println("result: " + l);
        System.out.println("avg: " + (now - then) / time);
    }

    private static double fibImpl(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n < 2) {
            return n;
        }
        double result = fibImpl(n - 1) + fibImpl(n - 2);
        if (Double.isInfinite(result)) {
            throw new ArithmeticException();
        }
        return result;
    }
}
