package first;
/*
ou are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

  Example 1:

    Given input matrix =
    [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ],

    rotate the input matrix in-place such that it becomes:
    [
      [7,4,1],
      [8,5,2],
      [9,6,3]
    ]
 */


import java.util.Arrays;

public class Problem48 {
    public static void main(String[] args) {
        Solution48 solution = new Solution48();

        int[][] matrix = {{1, 1, 2}, {2, 3, 5}, {5, 3, 2}};

        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

class Solution48 {
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        swapMatrixVertically(matrix);
    }

    private void transposeMatrix(int[][] matrix) {
        int matrixLength = matrix[0].length;

        for (int i = 0; i < matrixLength; i++) {
            for (int j = i; j < matrixLength; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void swapMatrixVertically(int[][] matrix) {
        int matrixLength = matrix[0].length;

        for (int i = 0; i < matrixLength; i++) {
            for(int j = 0; j < matrixLength/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrixLength-1-j];
                matrix[i][matrixLength-1-j] = temp;
            }
        }
    }
}