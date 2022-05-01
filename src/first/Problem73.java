package first;
/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

  Example 1:

    Input:
    [
      [1,1,1],
      [1,0,1],
      [1,1,1]
    ]
    Output:
    [
      [1,0,1],
      [0,0,0],
      [1,0,1]
    ]

  Example 2:

    Input:
    [
      [0,1,2,0],
      [3,4,5,2],
      [1,3,1,5]
    ]
    Output:
    [
      [0,0,0,0],
      [0,4,5,0],
      [0,3,1,0]
    ]
 */


import java.util.Arrays;

public class Problem73 {
    public static void main(String[] args) {
        Solution73 solution = new Solution73();

        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

class Solution73 {
    public void setZeroes(int[][] matrix) {
        int rowsCount = matrix.length, columnsCount = matrix[0].length;

        boolean isCol = false;

        for (int i = 0; i < rowsCount; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < columnsCount; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rowsCount; i++) {
            for (int j = 1; j < columnsCount; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < columnsCount; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isCol) {
            for (int i = 0; i < rowsCount; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
