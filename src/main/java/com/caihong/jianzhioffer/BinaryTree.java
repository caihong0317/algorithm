package com.caihong.jianzhioffer;

public class BinaryTree {
    Integer value;
    BinaryTree left;
    BinaryTree right;
    BinaryTree father;

    public BinaryTree() {
    }

    public BinaryTree(Integer value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(Integer value, BinaryTree left, BinaryTree right,BinaryTree father) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.father=father;
    }
    // 先序遍历打印
    public static void prePrintBinaryTree(BinaryTree root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        prePrintBinaryTree(root.left);
        prePrintBinaryTree(root.right);
    }

    // 中序遍历打印
    public static void middlePrintBinaryTree(BinaryTree root) {
        if (root == null) {
            return;
        }
        middlePrintBinaryTree(root.left);
        System.out.println(root.value + " ");
        middlePrintBinaryTree(root.right);
    }

    // 后序遍历打印
    public static void afterPrintBinaryTree(BinaryTree root) {
        if (root == null) {
            return;
        }
        afterPrintBinaryTree(root.left);
        afterPrintBinaryTree(root.right);
        System.out.println(root.value + " ");
    }

    @Override
    public String toString() {
        return  value +" ";
    }

    // review
    public static void prePrint(BinaryTree root) {
        if (root==null){
            return;
        }
        System.out.print(root);
        prePrint(root.left);
        prePrint(root.right);
    }
    public static void middlePrint(BinaryTree root) {
        if (root==null){
            return;
        }
        middlePrint(root.left);
        System.out.print(root);
        middlePrint(root.right);
    }

    public static void postPrint(BinaryTree root) {
        if (root==null){
            return;
        }
        postPrint(root.left);
        postPrint(root.right);
        System.out.print(root);
    }

    public static Integer findMin(BinaryTree root) {
        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root.value;
        }
        return findMin(root.left);
    }

    public static Integer findMax(BinaryTree root) {
        if (root == null) {
            return null;
        } else if (root.right == null) {
            return root.value;
        }
        return findMax(root.right);
    }
}
