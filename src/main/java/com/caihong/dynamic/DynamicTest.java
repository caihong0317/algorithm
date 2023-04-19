package com.caihong.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicTest {
    public static void main(String[] args) {
        People people = new Student();
        InvocationHandler handler = new WorkHandler(people);

        People proxy = (People) Proxy.newProxyInstance(people.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        // 连续代理
        People p = proxy.work("写代码").work("开会").work("上课");
        System.out.println("打印返回的对象: "+p.getClass());

        String time = proxy.time();
        System.out.println(time);
    }
}
