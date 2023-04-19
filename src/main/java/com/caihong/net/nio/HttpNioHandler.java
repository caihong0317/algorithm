package com.caihong.net.nio;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class HttpNioHandler extends NioHandler {
    public HttpNioHandler(int bufferSize, SelectionKey key) {
        super(bufferSize, key);
    }

    public void handleRead(SelectionKey key) throws IOException, ServletException {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        // 清空上次写入的
        buffer.clear();
        if (sc.read(buffer) == -1) {
            buffer.flip();
            String receive = Charset.forName(charset).decode(buffer).toString();
            String send = doHttpRequest(receive);
            buffer = ByteBuffer.wrap(send.getBytes(charset));
            sc.write(buffer);
            sc.close();
        }
    }

    private String doHttpRequest(String receive) throws ServletException, IOException {
        HttpServletRequest request = createRequest(receive);
        HttpServletResponse response = createResponse(receive);
        HttpServlet httpServlet = new EntryHttpServlet();
        httpServlet.service(request, response);
        return response.toString();
    }

    private HttpServletRequest createRequest(String receive) {
        return new HttpServletRequestWrapper(null);
    }

    private HttpServletResponse createResponse(String receive) {
        return new HttpServletResponseWrapper(null);
    }
}
