package com.caihong.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class C10KClient {
    public static void main(String[] args) {
        LinkedList<SocketChannel> list = new LinkedList<>();
        InetSocketAddress serverAddr = new InetSocketAddress("192.168.1.137", 8099);
        for (int i = 10000; i < 65000; i++) {
            try {
                SocketChannel client1 = SocketChannel.open();
                client1.bind(new InetSocketAddress("192.168.1.147", i));
                client1.connect(serverAddr);
                list.add(client1);

                SocketChannel client2 = SocketChannel.open();
                client2.bind(new InetSocketAddress("192.168.40.1", i));
                client2.connect(serverAddr);
                list.add(client2);
            } catch (IOException e) {

            }
        }
    }
}
