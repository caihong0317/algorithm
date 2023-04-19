package com.caihong.jianzhioffer;

// 对称二叉树
public class Question28 {

    public static void main(String[] args) {
        Question19 q = new Question19();
        BinaryTree left = new BinaryTree(3, null, null);
        BinaryTree right = new BinaryTree(3, null, null);
        BinaryTree root = new BinaryTree(2, left, right);
        System.out.print(isSymmetryTree(root,root));
    }

    // 左右逐位相比
    public static boolean isSymmetryTree(BinaryTree node1,BinaryTree node2) {
        if (node1 == null&&node2==null) {
            return true;
        }
        if (node1 == null||node2 == null){
            return false;
        }
        // 到达叶子节点时结束
        if (node1.value != node2.value) {
            return false;
        }
        return isSymmetryTree(node1.left,node2.right)&&isSymmetryTree(node1.right,node2.left);
    }
}