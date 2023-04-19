package com.caihong.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

// 最小值栈
public class Question31 {
    public static void main(String[] args) {
        int[] pushOrder = new int[]{1, 2, 3, 4, 5};
        int[] popOrder1 = new int[]{4, 5, 3, 2, 1};
        int[] popOrder2 = new int[]{4, 3, 5, 1, 2};
        int[] popOrder3 = new int[]{3, 5, 4, 2};
        System.out.println(isPopOrderForStack(pushOrder, popOrder1)); //true
        System.out.println(isPopOrderForStack(pushOrder, popOrder2)); //false
        System.out.println(isPopOrderForStack(pushOrder, popOrder3)); //true
    }

    public static boolean isPopOrderForStack(int[] pushOrder, int[] popOrder) {
        if (popOrder == null) {
            return true;
        }
        if (pushOrder == null || pushOrder.length == 0
            || pushOrder.length < popOrder.length) {
            return false;
        }
        boolean result = false;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushOrder.length; i++) {
            stack.push(pushOrder[i]);
            while (stack.size() > 0 && j < popOrder.length && popOrder[j] == stack.peek()) {
                stack.pop();
                j++;
            }
            if (j == popOrder.length) {
                result = true;
                break;
            }
        }
        return result;
    }
}