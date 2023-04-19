package com.caihong.net.nio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
    boolean match(String uri, String method);

    void handle(HttpServletRequest req, HttpServletResponse resp);
}
