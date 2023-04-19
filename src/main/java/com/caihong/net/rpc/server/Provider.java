package com.caihong.net.rpc.server;

public class Provider {
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.start("localhost",8090);
    }
}
