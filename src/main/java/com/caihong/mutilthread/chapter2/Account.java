package com.caihong.mutilthread.chapter2;

public class Account {
    private String name = "A";
    private String password = "AA";
    synchronized public void init(String name, String password){
        try {
            this.name = name;
            Thread.sleep(2000);
            this.password=password;
            System.out.println("init "+Thread.currentThread().getName()+this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 不加锁会产生脏读
    synchronized public String getValue(){
        return toString();
    }
    @Override
    public String toString() {
        return "Account{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}