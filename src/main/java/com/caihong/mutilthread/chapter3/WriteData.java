package com.caihong.mutilthread.chapter3;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
    public void writeMethod(PipedOutputStream outputStream) {
        try {
            System.out.println("write:");
            for (int i = 1; i <= 300; i++) {
                String outData = i + " ";
                System.out.println(outData);
                outputStream.write(outData.getBytes());
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}