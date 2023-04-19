package com.caihong.jianzhioffer;

//二叉树的深度
public class Question55 {

    public static void main(String[] args) {
        BinaryTree nine = new BinaryTree(10, null, null);
        BinaryTree eight = new BinaryTree(9, nine, null);
        BinaryTree seven = new BinaryTree(8, eight, null);
        BinaryTree six = new BinaryTree(6, null, null);
        BinaryTree five = new BinaryTree(4, null, null);
        BinaryTree four = new BinaryTree(2, null, null);
        BinaryTree three = new BinaryTree(7, six, seven);
        BinaryTree two = new BinaryTree(3, four, five);
        BinaryTree root = new BinaryTree(5, two, three);
        System.out.println(treeDepth(root)); //4
        System.out.println(isBalanceBinaryTree(root)); //true
        int[] array = new int[]{0};
        System.out.println(isBalanceBinaryTree2(root, array)); //true
    }

    // 55、 二分查找,O(logN),边界条件不好写，可用循环而不用递归
    private static int treeDepth(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 55-1、从上到下，存在重复运算
    private static boolean isBalanceBinaryTree(BinaryTree root) {
        if (root == null) {
            return true;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        int diff = leftDepth - rightDepth;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanceBinaryTree(root.left) && isBalanceBinaryTree(root.right);
    }

    // 55-2、从下到上，避免重复运算。但如何将depth跨层传递？使用Integer不行
    private static boolean isBalanceBinaryTree2(BinaryTree root, int[] depth) {
        if (root == null) {
            return true;
        }
        int[] leftDepth = {0};
        int[] rightDepth = {0};
        if (isBalanceBinaryTree2(root.left, leftDepth) && isBalanceBinaryTree2(root.right, rightDepth)) {
            int diff = leftDepth[0] - rightDepth[0];
            if (diff > 1 || diff < -1) {
                return false;
            } else {
                depth[0] = Math.max(leftDepth[0], rightDepth[0]) + 1;
                return true;
            }
        }
        return false;
    }
}