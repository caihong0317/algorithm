package com.caihong.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class InetTest {
    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); // caihong/192.168.40.1

//        new BufferedInputStream(new FileInputStream())
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

        ServerSocket serverSocket = new ServerSocket(8099);
        Socket socket = serverSocket.accept();
        socket.setTcpNoDelay(false);
        socket.setOOBInline(false);
        socket.setSendBufferSize(20);
        socket.setKeepAlive(true);

        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buff)) != -1) {
            System.out.println(new String(buff, 0, length));
        }
        socket.shutdownInput();
        socket.close();
    }
}
