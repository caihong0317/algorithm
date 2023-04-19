package com.caihong.jianzhioffer;

import java.util.Stack;

// 两个栈实现队列
public class Question9 {

    public static void main(String[] args) {
        SimulateQueue<Integer> queue = new SimulateQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        queue.appendTail(5);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    //模拟队列
    public static class SimulateQueue<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        public SimulateQueue() {
        }

        public void appendTail(T t) {
            stack1.push(t);
        }

        // 方式1
        public T deleteHead() {
            T head = null;
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (!stack2.isEmpty()) {
                head = stack2.pop();
            }
            return head;
        }

        // 只临时使用stack2，不及方式1好
        public T deleteHead2() {
            if (stack1.isEmpty()) {
                return null;
            }
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            T head = stack1.pop();
            if (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return head;
        }

    }
}