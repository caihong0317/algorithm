package com.caihong.net.nio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractHandler implements Handler {
    protected String path;
    protected String methodType;
    protected static final List<Handler> HANDLER_LIST = new ArrayList<>(16);
    protected static final Map<String, Handler> HANDLER_CACHE = new ConcurrentHashMap<>(16);

    public AbstractHandler(String path, String methodType) {
        this.path = path;
        this.methodType = methodType;
    }

    public static Handler getHandler(String uri, String method) {
        Handler result = HANDLER_CACHE.get(uri);
        if (result != null) {
            return result;
        }
        for (Handler handler : HANDLER_LIST) {
            if (handler.match(uri, method)) {
                HANDLER_CACHE.put(uri, handler);
                return handler;
            }
        }
        throw new RuntimeException("无法匹配此URI");
    }

    public abstract boolean match(String uri, String method);

    public abstract void handle(HttpServletRequest req, HttpServletResponse resp);
}
