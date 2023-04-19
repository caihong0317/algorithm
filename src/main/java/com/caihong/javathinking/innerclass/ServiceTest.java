package com.caihong.javathinking.innerclass;

public class ServiceTest {
    public static void consumer(ServiceFactory factory){
        Service service = factory.getService();
        service.server1();
        service.server2();
    }
    public static void main(String[] args) {
        consumer(ServiceImpl1.factory);
        consumer(ServiceImpl2.factory);
    }
}
