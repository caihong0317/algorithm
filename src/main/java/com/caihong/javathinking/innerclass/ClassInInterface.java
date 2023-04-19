package com.caihong.javathinking.innerclass;

public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface{

        @Override
        public void howdy() {
            System.out.println("Test howdy");
        }

        public static void main(String[] args) {
            Test test = new Test();
            test.howdy();
        }
    }
}
