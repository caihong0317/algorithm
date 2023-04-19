package com.caihong.jianzhioffer;

public class Question7 {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree binaryTree = rebuildBinaryTree(pre, mid, 0, pre.length - 1, 0, mid.length - 1);
        BinaryTree.prePrintBinaryTree(binaryTree);
    }

    // index从0开始
    public static BinaryTree rebuildBinaryTree(int[] preOrder, int[] minOrder, int preStart, int preEnd, int minStart, int minEnd) {
        if (preOrder == null || minOrder == null || preStart < 0 || minStart < 0) {
            return null;
        }
        // preStart=preEnd或minStart=minEnd时，为叶子节点
        if (preStart > preEnd || minStart > minEnd) {
            return null;
        }
        int rootIndex = 0;
        for (int i = minStart; i <= minEnd; i++) {
            if (minOrder[i] == preOrder[preStart]) {
                rootIndex = i;
                break;
            }
        }
        BinaryTree root = new BinaryTree(preOrder[preStart], null, null);
        int leftRange = rootIndex - minStart;
        root.left = rebuildBinaryTree(preOrder, minOrder, preStart + 1, preStart + leftRange, minStart, rootIndex - 1);
        root.right = rebuildBinaryTree(preOrder, minOrder, preStart + leftRange + 1, preEnd, rootIndex + 1, minEnd);
        return root;
    }
}
