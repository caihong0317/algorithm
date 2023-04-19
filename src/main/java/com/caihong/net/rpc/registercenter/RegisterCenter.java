package com.caihong.net.rpc.registercenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterCenter {
    private static final ConcurrentHashMap<String, List<URL>> serviceMap = new ConcurrentHashMap<>();

    public void registry(String serviceName, URL url) {
        List<URL> urlList = serviceMap.get(serviceName);
        if (urlList == null) {
            urlList = new ArrayList<>(16);
        }
        urlList.add(url);
        serviceMap.put(serviceName, urlList);
    }

    public List<URL> get(String serviceName) {
        return serviceMap.get(serviceName);
    }
}
