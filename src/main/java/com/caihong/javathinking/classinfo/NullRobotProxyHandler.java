package com.caihong.javathinking.classinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

public class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    // 实例化为NullRobot而非其他Robot的实现类
    private Robot proxied = new NullRobot();

    public NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }

    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(Robot.class.getClassLoader(), new Class[]{Robot.class, Null.class},
            new NullRobotProxyHandler(type));
    }

    // 私有内部类
    private class NullRobot implements Null, Robot {
        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        Robot robot = newNullRobot(SnowRemovalRobot.class);
        System.out.println(robot.name());
        System.out.println(robot.model());
        System.out.println(robot.operations());
    }
}
