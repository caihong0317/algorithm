package com.caihong.mutilthread.chapter2;

public class PrintStringTest {
    public static void main(String[] args) {
/*
        PrintString printString = new PrintString();
        printString.setContinue(true);
        printString.printMethod();
        System.out.println("stop printMethod"); // 不会被执行，无法停止
        printString.setContinue(false);
*/

        PrintString printString = new PrintString();
        printString.setContinue(true);
        new Thread(printString).start();
        try {
            Thread.sleep(4000);
            System.out.println("stop printMethod");
            printString.setContinue(false); // 成功停止，但与环境有关
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
