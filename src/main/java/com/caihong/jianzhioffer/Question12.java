package com.caihong.jianzhioffer;

public class Question12 {
    private static int pathLength = 0;

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        System.out.println(hasPath(matrix, "bfce"));
        System.out.println(hasPath(matrix, "abfb"));
    }

    synchronized public static boolean hasPath(char[][] matrix, String target) {
        if (matrix == null) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[] chars = target.toCharArray();
        boolean[][] visited = new boolean[rows][cols];
        boolean result = false;
        A:
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, chars, visited)) {
                    result = true;
                    break A;
                }
            }
        }
        pathLength = 0;
        return result;
    }

    private static boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, char[] chars, boolean[][] visited) {
        if (pathLength == chars.length) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
            && matrix[row][col] == chars[pathLength]
            && !visited[row][col]) {
            pathLength++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row + 1, col, chars, visited)
                || hasPathCore(matrix, rows, cols, row - 1, col, chars, visited)
                || hasPathCore(matrix, rows, cols, row, col + 1, chars, visited)
                || hasPathCore(matrix, rows, cols, row, col - 1, chars, visited);
            if (!hasPath) {
                pathLength--;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}