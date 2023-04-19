package com.caihong.jianzhioffer;

import java.util.ArrayDeque;
import java.util.Stack;

// 从上到下，逐层打印二叉树
public class Question32 {

    public static void main(String[] args) {
        BinaryTree eleven = new BinaryTree(11, null, null);
        BinaryTree ten = new BinaryTree(10, null, null);
        BinaryTree nine = new BinaryTree(9, null, null);
        BinaryTree eight = new BinaryTree(8, null, null);
        BinaryTree seven = new BinaryTree(7, null, null);
        BinaryTree six = new BinaryTree(6, null, null);
        BinaryTree five = new BinaryTree(5, ten, eleven);
        BinaryTree four = new BinaryTree(4, eight, nine);
        BinaryTree three = new BinaryTree(3, six, seven);
        BinaryTree two = new BinaryTree(2, four, five);
        BinaryTree root = new BinaryTree(1, two, three);

        printFromTopToBottom(root);
        System.out.println();
        printFromTopToBottom2(root);
        System.out.println();
        printFromTopToBottom3(root);
    }

    public static void printFromTopToBottom(BinaryTree root) {
        if (root == null) {
            return;
        }
        ArrayDeque<BinaryTree> deque = new ArrayDeque<>();
        deque.offer(root);
        while (deque.size() > 0) {
            BinaryTree node = deque.pop();
            System.out.print(node+" ");
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
    }

    // 逐层逐行打印
    public static void printFromTopToBottom2(BinaryTree root) {
        if (root == null) {
            return;
        }
        ArrayDeque<BinaryTree> deque = new ArrayDeque<>();
        deque.offer(root);
        int toBePrinted = 1;
        int nextLevel = 0;
        while (deque.size() > 0) {
            BinaryTree node = deque.pop();
            System.out.print(node);
            toBePrinted--;
            if (node.left != null) {
                deque.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                deque.offer(node.right);
                nextLevel++;
            }
            if (toBePrinted == 0) {
                toBePrinted = nextLevel;
                nextLevel = 0;
                System.out.println();
            }
        }
    }

    // 之字形逐层逐行打印
    public static void printFromTopToBottom3(BinaryTree root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stackOne = new Stack<>();
        Stack<BinaryTree> stackTwo = new Stack<>();
        stackOne.push(root);
        int level = 0;
        while (stackOne.size() != 0 || stackTwo.size() != 0) {
            if (level == 0) {
                BinaryTree node = stackOne.pop();
                System.out.print(node);
                if (node.left != null) {
                    stackTwo.push(node.left);
                }
                if (node.right != null) {
                    stackTwo.push(node.right);
                }
                if (stackOne.size() == 0) {
                    level = 1;
                    System.out.println();
                }
            } else {
                BinaryTree node = stackTwo.pop();
                System.out.print(node);
                if (node.right != null) {
                    stackOne.push(node.right);
                }
                if (node.left != null) {
                    stackOne.push(node.left);
                }
                if (stackTwo.size() == 0) {
                    level = 0;
                    System.out.println();
                }
            }
        }
    }

}