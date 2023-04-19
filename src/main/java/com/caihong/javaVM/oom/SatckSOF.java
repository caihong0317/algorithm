package com.caihong.javaVM.oom;

public class SatckSOF {
    private int length = 1;

    public void add() {
        length++;
        add();
    }

    public static void main(String[] args) {
        SatckSOF sof = new SatckSOF();
        try {
            sof.add();
        } catch (Throwable e) {
            System.out.println("length: " + sof.length);
            throw e;
        }
    }
}
