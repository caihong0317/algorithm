package com.caihong.javaVM;

public class TestEx {
    public static void main(String[] args) {
        System.out.println(testException()); // 不可能返回3
    }

    public static int testException() {
        int x;
        String s = null;
        int i;
        try {
            x = 1;
//            char[] chars = s.toCharArray();
            i = 1 / 0;
            return x;
        } catch (NullPointerException e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}

