package com.caihong.net;

import java.util.ArrayList;
import java.util.List;

// 系统调用、本地调用的比较
public class SystemCallTest {
    public static void main(String[] args) throws InterruptedException {
        String msg = "hello";
        long start = System.currentTimeMillis();
//        sysPrint(msg); // 320
        localPrint(msg); // 5
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void sysPrint(String msg) {
        for (int i = 0; i < 10000; i++) {
            System.out.println(msg);
        }
    }

    public static void localPrint(String msg) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(msg);
//            Thread.sleep(1);
        }
    }
}
