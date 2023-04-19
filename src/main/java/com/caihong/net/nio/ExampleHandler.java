package com.caihong.net.nio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExampleHandler extends AbstractHandler {
    static {
        HANDLER_LIST.add(new ExampleHandler("/test/.*", "GET"));
    }

    public ExampleHandler(String path, String methodType) {
        super(path, methodType);
    }

    @Override
    public boolean match(String uri, String method) {
        return methodType.equals(method) && uri.matches(path);
    }

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp) {
        businessLogic(req, resp);
    }

    private void businessLogic(HttpServletRequest req, HttpServletResponse resp) {
    }
}
