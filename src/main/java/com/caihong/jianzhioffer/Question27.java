package com.caihong.jianzhioffer;

public class Question27 {

    public static void main(String[] args) {
        Question19 q = new Question19();
        BinaryTree left = new BinaryTree(1, null, null);
        BinaryTree right = new BinaryTree(3, null, null);
        BinaryTree root = new BinaryTree(2, left, right);
        System.out.print("初始顺序: ");
        root.prePrintBinaryTree(root);
        mirrorBinaryTree(root);
        System.out.print("\n镜像顺序: ");
        root.prePrintBinaryTree(root);
    }

    // 不应该改变了root本身
    public static void mirrorBinaryTree(BinaryTree root) {
        if (root == null) {
            return;
        }
        // 到达叶子节点时结束
        if (root.left == null && root.right == null) {
            return;
        }
        BinaryTree tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
    }
}