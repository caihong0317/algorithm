package com.caihong.mutilthread.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedSteamTest {
    public static void main(String[] args) {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        try {
            inputStream.connect(outputStream);
            WriteThread writeThread = new WriteThread(writeData, outputStream);
            ReadThread readThread = new ReadThread(readData, inputStream);
            readThread.start();
            Thread.sleep(2000);
            writeThread.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
