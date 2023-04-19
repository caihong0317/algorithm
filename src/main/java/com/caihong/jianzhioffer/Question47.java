package com.caihong.jianzhioffer;

public class Question47 {
    public static void main(String[] args) {
        int[][] values = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(findMax1(values, 4, 4));
        System.out.println(findMax2(values, 4, 4));
    }

    public static int findMax1(int[][] values, int row, int col) {
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = temp[i - 1][j];
                }
                if (j > 0) {
                    left = temp[i][j - 1];
                }
                temp[i][j] = values[i][j] + Math.max(up, left);
            }
        }
        return temp[row - 1][col - 1];
    }

    public static int findMax2(int[][] values, int row, int col) {
        int[] temp = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = temp[j];
                int left = 0;
                if (j > 0) {
                    left = temp[j - 1];
                }
                temp[j] = values[i][j] + Math.max(up, left);
            }
        }
        return temp[col - 1];
    }
}
