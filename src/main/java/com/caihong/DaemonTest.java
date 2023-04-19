package com.caihong;

import java.util.Collections;

public class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        String join = String.join("/", Collections.emptyList());
        System.out.println(join); // 输出空
//        extracted();
    }

    private static void extracted() throws InterruptedException {
        Thread daemon1 = new Thread(() -> {
            System.out.println("Daemon 1");
            Thread daemon2 = new Thread(() -> {
                System.out.println("Daemon 2");

            });
            daemon2.setDaemon(true);
            daemon2.start();
        });
        daemon1.setDaemon(true);
        daemon1.start();

        Thread.sleep(5000);
        System.out.println("main ");
    }
}
