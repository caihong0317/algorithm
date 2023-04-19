package com.caihong.designpattern.chain;

public class ConcreteHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (canHandle(request)) {
            handle(request);
        } else {
            next.handleRequest(request);
        }
    }

    private void handle(String request) {
    }

    private boolean canHandle(String request) {
        return request.contains("level3");
    }
}
