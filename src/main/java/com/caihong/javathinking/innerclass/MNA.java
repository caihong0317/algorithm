package com.caihong.javathinking.innerclass;

public class MNA {
    private void f(){
        System.out.println("MNA f()");
    }
    class A{
        private void g(){
            System.out.println("A g()");
        }
        class B{
            void apply(){
                f();
                g();
            }
        }
    }

    public static void main(String[] args) {
        A.B b = new MNA().new A().new B();
        b.apply();
    }
}
