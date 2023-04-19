package com.caihong.net.rpc.registercenter;

public class URL {
    private String hostName;
    private String ipAddr;
    private int port;

    public URL(String hostName, String ipAddr, int port) {
        this.hostName = hostName;
        this.ipAddr = ipAddr;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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
}
