package com.caihong.cleancode;

//子类中与父类相同的非静态方法声明，会自动复写父类该方法
//子类中与父类相同的静态方法声明，不会覆盖父类的静态方法
public class SubClass extends Father{
    public void methodA(){
        System.out.println("SubClass normal methodA");
    }

    public static void methodB(){
        System.out.println("SubClass static methodB");
    }



    public static void main(String[] args) {
        Father subClass = new SubClass();
        subClass.methodA();
        subClass.methodB(); //FatherMethod static methodB
        SubClass subClass2 = new SubClass();
        subClass2.methodA();
        subClass2.methodB();

/*
        if (subClass instanceof Father){

        }
*/
    }
}
