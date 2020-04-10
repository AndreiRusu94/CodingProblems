/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

  Example 1:

    Input:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 3
    Output: true

  Example 2:

    Input:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 13
    Output: false
 */


import java.util.Arrays;

public class Problem74 {
    public static void main(String[] args) {
        Solution74 solution = new Solution74();

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(solution.searchMatrix(matrix, 11));
    }
}

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int start = 0, end = matrix.length * matrix[0].length - 1, m = matrix[0].length;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (matrix[middle / m][middle % m] == target) {
                return true;
            }

            if (matrix[middle / m][middle % m] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return false;
    }
}
