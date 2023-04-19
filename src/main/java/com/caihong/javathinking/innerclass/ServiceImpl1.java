package com.caihong.javathinking.innerclass;

public class ServiceImpl1 implements Service {
    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ServiceImpl1();
        }
    };

    private ServiceImpl1() {
    }

    @Override
    public void server1() {
        System.out.println("ServiceImpl1 server1");
    }

    @Override
    public void server2() {
        System.out.println("ServiceImpl1 server2");
    }
}
