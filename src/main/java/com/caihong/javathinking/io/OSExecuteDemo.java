package com.caihong.javathinking.io;

public class OSExecuteDemo {
    private int i = 10;

    public void method1() {

    }

    private void method2() {

    }

    public static void main(String[] args) {
        OSExecute.command("javap OSExecuteDemo"); // 报错
    }
}
