package com.caihong.jianzhioffer;

public class Question26 {

    public static void main(String[] args) {

    }

    public static boolean hasSubTree(BinaryTree root, BinaryTree subTree) {
        if (subTree == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        boolean result = false;
        if (root.value == subTree.value) {
            result = checkIsSubTree(root, subTree);
        }
        if (!result) {
            result = hasSubTree(root.left, subTree.left);
        }
        if (!result) {
            result = hasSubTree(root.right, subTree.right);
        }
        return result;
    }

    private static boolean checkIsSubTree(BinaryTree root, BinaryTree subTree) {
        if (subTree == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.value != subTree.value) {
            return false;
        } else {
            return checkIsSubTree(root.left, subTree.right) && checkIsSubTree(root.right, subTree.right);
        }
    }

    // 判断double值相等
    public boolean doubleIsEqual(double one, double two) {
        final double precision = 0.00000001;
        if (one - two > -precision && one - two < precision) {
            return true;
        }
        return false;
    }
}