package com.caihong.jianzhioffer;

// 二维数组查找
public class Question4 {
    public static void main(String[] args) {
        int[][] array1={{1,4,7}};
        int[][] array2 = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        //
        System.out.println(findNumber(array1, 7));
        System.out.println(findNumber(array1, 5));
        System.out.println(findNumber(array2, 7));
        System.out.println(findNumber(array2, 5));
    }

    public static boolean findNumber(int[][] matrix, int number) {
        if (matrix == null && matrix.length <= 0) {
            return false;
        }
        boolean flag = false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (matrix[row][column] == number) {
                flag = true;
                break;
            } else if (matrix[row][column] < number) {
                row++;
            } else {
                column--;
            }
        }
        return flag;
    }
}
