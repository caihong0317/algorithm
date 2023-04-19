package com.caihong.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicTest {
    private static AtomicReference<User> atomicReference = new AtomicReference<>();
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        User old = new User("li", 15);
        atomicReference.set(old);
        User wang = new User("wang", 20);
        atomicReference.compareAndSet(old,wang);
        System.out.println(atomicReference.get().getName());
    }

    static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
