package com.caihong.javaVM.oom;

public class JHSDBTest {
    private static class ObjectHolder{}
    static class Test{
         static ObjectHolder sta=new ObjectHolder();
         ObjectHolder ins=new ObjectHolder();
          static void foo(){
             ObjectHolder loc = new ObjectHolder();
             System.out.println("done");
         }
    }

    public static void main(String[] args) {
        Test.foo();
    }
}
