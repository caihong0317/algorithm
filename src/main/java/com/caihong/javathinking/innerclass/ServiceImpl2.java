package com.caihong.javathinking.innerclass;

public class ServiceImpl2 implements Service {
    public static ServiceFactory factory = ServiceImpl2::new;

    private ServiceImpl2() {
    }

    @Override
    public void server1() {
        System.out.println("ServiceImpl2 server1");
    }

    @Override
    public void server2() {
        System.out.println("ServiceImpl2 server2");
    }
}
