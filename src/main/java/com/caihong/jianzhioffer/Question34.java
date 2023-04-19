package com.caihong.jianzhioffer;

import java.util.Stack;

// 和为某值的路径
public class Question34 {
    public static void main(String[] args) {
        BinaryTree left1 = new BinaryTree(4, null, null);
        BinaryTree left2 = new BinaryTree(7, null, null);
        BinaryTree left = new BinaryTree(5, left1, left2);
        BinaryTree right = new BinaryTree(12, null, null);
        BinaryTree root = new BinaryTree(10, left, right);
        findPath(root, 22);
    }

    public static void findPath(BinaryTree tree, int target) {
        if (tree == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
//        findPathInTree(tree, target, stack);
        int sum = 0;
        findPathInTree2(tree, target, stack, sum);
    }

    // 每入栈一个元素，则进行处理.
    private static void findPathInTree(BinaryTree tree, int target, Stack<BinaryTree> stack) {
        stack.push(tree);
        // 叶子节点，tree!=null
        if (tree.left == null && tree.right == null) {
            int sum = 0;
            // 不用每次都遍历
            for (BinaryTree binaryTree : stack) {
                sum += binaryTree.value;
            }
            if (sum == target) {
                for (BinaryTree binaryTree : stack) {
                    System.out.print(binaryTree.toString());
                }
                System.out.println();
            }
        }

        // 非叶子节点
        if (tree.left != null) {
            findPathInTree(tree.left, target, stack);
        }
        if (tree.right != null) {
            findPathInTree(tree.right, target, stack);
        }
        // 处理完当前节点后，都需弹出
        stack.pop();
    }

    private static void findPathInTree2(BinaryTree tree, int target, Stack<BinaryTree> stack, int sum) {
        stack.push(tree);
        sum += tree.value;
        // 叶子节点，tree!=null
        if (tree.left == null && tree.right == null && sum == target) {
            for (BinaryTree binaryTree : stack) {
                System.out.print(binaryTree.toString());
            }
            System.out.println();
        }

        // 非叶子节点
        if (tree.left != null) {
            findPathInTree2(tree.left, target, stack, sum);
        }
        if (tree.right != null) {
            findPathInTree2(tree.right, target, stack, sum);
        }
        // 处理完当前节点后，都需弹出
        stack.pop();
    }
}