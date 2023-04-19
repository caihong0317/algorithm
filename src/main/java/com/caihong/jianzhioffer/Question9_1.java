package com.caihong.jianzhioffer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

// 两个队列实现栈
public class Question9_1 {

    public static void main(String[] args) {
        SimulateStack<Integer> stack = new SimulateStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    //模拟栈
    public static class SimulateStack<T> {
        private Queue<T> queue1 = new ArrayDeque<>();
        private Queue<T> queue2 = new ArrayDeque<>();
        private int popCount = 0;

        public SimulateStack() {
        }

        public void push(T t) {
            if (popCount % 2 == 0) {
                queue1.add(t);
            } else {
                queue2.add(t);
            }
        }

        public T pop() {
            T head = null;
            if (popCount % 2 == 0) {
                if (queue1.size() == 0) {
                    return null;
                }
                while (queue1.size() > 1) {
                    queue2.add(queue1.remove());
                }
                head = queue1.remove();
            } else {
                if (queue2.size() == 0) {
                    return null;
                }
                while (queue2.size() > 1) {
                    queue1.add(queue2.remove());
                }
                head = queue2.remove();
            }
            popCount++;
            return head;
        }
    }
}