package com.caihong;

public class TestLoad {
    public static int static_var = 10;

    static {
        static_var += 10;
        System.out.println("Test       static block static_var: " + static_var);
    }

    public TestLoad(){
        static_var += 10;
        System.out.println("Test       variable static_var: " + static_var);
    }

    public static void print(){
        static_var += 10;
        System.out.println("Test       Function static_var: " + static_var);
    }

    {
        static_var += 10;
        System.out.println("Test       block static_var: " + static_var);
    }

    public static void main(String[] args){
//        TestLoad.print();
        TestLoad testLoad = new TestLoad();
        testLoad.print();
    }
}
