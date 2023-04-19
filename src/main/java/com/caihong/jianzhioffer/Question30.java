package com.caihong.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

// 最小值栈
public class Question30 {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(4);
        stack.push(7);
        System.out.println(stack.min()); //4
        stack.push(5);
        stack.push(1);
        stack.push(3);
        System.out.println(stack.min()); //1
        stack.pop();
        stack.pop();
        System.out.println(stack.min()); //4

    }

    public static class StackWithMin {
        private ArrayList<Integer> array = new ArrayList<>();
        private Stack<Integer> minStack = new Stack<>();

        public Integer min() {
            Integer min = null;
            if (minStack.size() > 0) {
                min = minStack.peek();
            }
            return min;
        }

        public void push(Integer t) {
            array.add(t);
            Integer min = t;
            if (minStack.size() > 0) {
                min = minStack.peek();
                if (min > t) {
                    min = t;
                }
            }
            minStack.push(min);
        }

        public Integer pop() {
            Integer t = null;
            if (array.size() > 0) {
                t = array.remove(array.size() - 1);
                minStack.pop();
            }
            return t;
        }
    }
}