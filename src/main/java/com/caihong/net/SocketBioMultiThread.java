package com.caihong.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketBioMultiThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8099);
        System.out.println("1:new ServerSocket(8099) ");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("2:client " + socket.getPort());

            BIORunnable runnable = new BIORunnable();
            runnable.setSocket(socket);
            new Thread(runnable).start();
        }
    }

    public static class BIORunnable implements Runnable {
        Socket socket;

        public void setSocket(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            BufferedReader reader = null;
            try {
                inputStream = socket.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                int length;
                while (true) {
                    System.out.println(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
