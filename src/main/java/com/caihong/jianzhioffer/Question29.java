package com.caihong.jianzhioffer;

// 顺时针打印矩阵
public class Question29 {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        clockWiselyPrintMatrix(array, 4, 4);
    }

    // 逐圈打印
    public static void clockWiselyPrintMatrix(int[][] matrix, int rows, int columns) {
        if (matrix == null || rows <= 0 || columns <= 0) {
            return;
        }
        int start = 0;
        while (rows > start * 2 && columns > start * 2) {
            printMatrixCircle(matrix, rows, columns, start);
            start++;
        }
    }

    private static void printMatrixCircle(int[][] matrix, int rows, int columns, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        //上边行
        for (int i = start; i <= endX; i++) {
            System.out.print(matrix[start][i] + " ");
        }
        //右边列
        if (start < endY) {
            for (int i = start+1; i <= endY; i++) {
                System.out.print(matrix[i][endX] + " ");
            }
        }
        //下边行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(matrix[endY][i] + " ");
            }
        }
        //左边列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.print(matrix[i][start] + " ");
            }
        }
        System.out.println();
    }
}