package com.caihong.net.rpc.server;

import java.util.concurrent.ConcurrentHashMap;

public class LocalRegister {
    private static final ConcurrentHashMap<String, Object> register = new ConcurrentHashMap<>(16);

    public void registry(String interfaceName, Object impl) {
        register.put(interfaceName, impl);
    }

    public Object getImpl(String interfaceName) {
        return register.get(interfaceName);
    }
}
