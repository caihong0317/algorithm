package com.caihong.jianzhioffer;

public class Question26Review {

    public static void main(String[] args) {

    }

    public static boolean hasSubTree(BinaryTree root, BinaryTree sub) {
        if (sub == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        boolean result = false;
        if (root.value.equals(sub.value)) {
            result = checkIsSubTree(root, sub);
        }
        if (!result) {
            result = hasSubTree(root.left, sub);
        }
        if (!result) {
            result = hasSubTree(root.right, sub);
        }
        return result;
    }

    private static boolean checkIsSubTree(BinaryTree root, BinaryTree sub) {
        if (sub == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.value.equals(sub.value)) {
            return checkIsSubTree(root.left, sub.left) && checkIsSubTree(root.right, sub.right);
        } else {
            return false;
        }
    }
}