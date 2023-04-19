package com.caihong.net.nio;

import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public abstract class NioHandler implements Runnable {
    protected int bufferSize = 1024;
    protected String charset = "UTF-8";
    protected SelectionKey key;


    public NioHandler(int bufferSize, SelectionKey key) {
        this(bufferSize, null, key);
    }

    public NioHandler(int bufferSize, String charset, SelectionKey key) {
        if (bufferSize > 0) {
            this.bufferSize = bufferSize;
        }
        if (charset != null) {
            this.charset = charset;
        }
        this.key = key;
    }

    public void handleAccept(SelectionKey key) throws IOException {
        SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
    }

    public abstract void handleRead(SelectionKey key) throws IOException, ServletException;

    @Override
    public void run() {
        try {
            if (key.isAcceptable()) {
                handleAccept(key);
            }
            if (key.isReadable()) {
                handleRead(key);
            }
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
        }
    }
}

