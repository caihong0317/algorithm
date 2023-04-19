package com.caihong.mutilthread.chapter2;

public class PrintString implements Runnable {

    volatile private boolean isContinue;

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public void printMethod(){
        try {
            while (isContinue){
                System.out.println("run printMethod = "+Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printMethod();
    }
}
