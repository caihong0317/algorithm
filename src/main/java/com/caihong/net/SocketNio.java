package com.caihong.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;

public class SocketNio {
    public static final LinkedList<SocketChannel> LIST = new LinkedList<>();
    public static final int capacity = 1024 * 4;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(9999)).configureBlocking(false);
        while (true) {
            SocketChannel sc = ssc.accept();
            if (sc == null) {
                System.out.println(System.currentTimeMillis() + ":无连接");
            } else {
                sc.configureBlocking(false);
                LIST.add(sc);
                InetAddress inetAddress = sc.socket().getInetAddress();
                System.out.println("新连接" + inetAddress);
            }

            ByteBuffer buffer = ByteBuffer.allocate(capacity);
            for (SocketChannel channel : LIST) {
                int num = channel.read(buffer);
                if ((num > 0)) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.limit()];
                    buffer.get(bytes);
                    String content = new String(bytes);
                    System.out.println(channel.socket().getPort() + ":" + content);
                    buffer.clear();
                }
            }
        }
    }
}
