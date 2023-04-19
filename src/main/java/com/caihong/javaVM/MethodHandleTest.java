package com.caihong.javaVM;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
    static class Any {
        public void println(String s) {
            System.out.println("Any:" + s);
        }
    }

    public static void main(String[] args) throws Throwable {
        for (int i = 0; i < 5; i++) {
            Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new Any();
            getMethodHandle(obj).invokeExact("hello");
        }
    }

    public static MethodHandle getMethodHandle(Object obj) throws NoSuchMethodException, IllegalAccessException {
        MethodType type = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(obj.getClass(), "println", type).bindTo(obj);
    }
}
