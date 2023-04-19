package com.caihong.net.nio;

import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.channels.SelectionKey;

public class JspNioHandler extends NioHandler {
    public JspNioHandler(int bufferSize, SelectionKey key) {
        super(bufferSize, key);
    }

    public JspNioHandler(int bufferSize, String charset, SelectionKey key) {
        super(bufferSize, charset, key);
    }

    @Override
    public void handleRead(SelectionKey key) throws IOException, ServletException {

    }
}
