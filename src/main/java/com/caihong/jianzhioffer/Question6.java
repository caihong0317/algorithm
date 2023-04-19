package com.caihong.jianzhioffer;

import java.util.LinkedList;
import java.util.Stack;

public class Question6 {

    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        reversePrintLinkedList(list);
    }

    public static void reversePrintLinkedList(LinkedList<Object> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Stack<Object> stack = new Stack<>();
        for (Object obj : list) {
            stack.push(obj);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
