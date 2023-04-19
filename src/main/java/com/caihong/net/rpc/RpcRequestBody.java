package com.caihong.net.rpc;

import java.io.Serializable;
import java.util.List;

public class RpcRequestBody implements Serializable {
    private String ipAddr;
    private int port;
    private String className;
    private String methodName;
    private Class[] parameterTypes;
    private List<Object> parameterList;

    public RpcRequestBody() {
    }

    public RpcRequestBody(String ipAddr, int port, List<Object> parameterList) {
        this.ipAddr = ipAddr;
        this.port = port;
        this.parameterList = parameterList;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public List<Object> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Object> parameterList) {
        this.parameterList = parameterList;
    }
}
