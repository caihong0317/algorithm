package com.caihong.jianzhioffer;

import java.util.Stack;

// 最小值栈
public class Question33 {
    public static void main(String[] args) {
        int[] afterOrder1 = new int[]{5,7,6,9,11,10,8};
        int[] afterOrder2 = new int[]{5,6,7,11,10,9,8};
        System.out.println(isBinaryTree(afterOrder1, 0, afterOrder1.length - 1)); //true
        System.out.println(isBinaryTree(afterOrder2, 0, afterOrder2.length - 1)); //true
    }

    public static boolean isBinaryTree(int[] afterOrder, int startIndex, int endIndex) {
        if (afterOrder == null || afterOrder.length == 0) {
            return false;
        }
        if (startIndex >= endIndex) {
            return true;
        }
        int i;
        // i有3种取值：i = startIndex、i=endIndex、i在中间
        for (i = startIndex; i < endIndex; i++) {
            if (afterOrder[i] > afterOrder[endIndex]) {
                break;
            }
        }
        for (int j = i; j < endIndex; j++) {
            if (afterOrder[j] < afterOrder[endIndex]) {
                return false;
            }
        }
        return isBinaryTree(afterOrder, startIndex, i - 1) && isBinaryTree(afterOrder, i, endIndex - 1);
    }
}