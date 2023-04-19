package com.caihong.javaVM;

public class FieldNoPolymorphic {
    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            show();
        }

        public void show() {
            System.out.println("Father, money=" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            show();
        }

        public void show() {
            System.out.println("Son, money=" + money);
        }
    }

    public static void main(String[] args) {
//        Son gay = new Son();
        Father gay = new Son();
        System.out.println(gay.money);
    }
}
