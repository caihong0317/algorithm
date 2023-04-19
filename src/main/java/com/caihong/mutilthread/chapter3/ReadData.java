package com.caihong.mutilthread.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ReadData {
    public void readMethod(PipedInputStream inputStream) {
        try {
            System.out.println("read:");
            byte[] bytes = new byte[1024*8];  // 会受此大小影响
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes)); // 为何是无序的
                inputStream.read(bytes, 0, length);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}