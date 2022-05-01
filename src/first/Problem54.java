package first;
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

  Example 1:

    Input:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    Output: [1,2,3,6,9,8,7,4,5]

  Example 2:

    Input:
    [
      [1, 2, 3, 4],
      [5, 6, 7, 8],
      [9,10,11,12]
    ]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public static void main(String[] args) {
        Solution54 solution = new Solution54();

        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(solution.spiralOrder(nums));
    }
}

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int topRow = 0, rightColumn = matrix[0].length - 1, leftColumn = 0, bottomRow = matrix.length - 1;
        List<Integer> output = new ArrayList<>();

        while (topRow <= bottomRow && leftColumn <= rightColumn) {
            for (int column = leftColumn; column <= rightColumn; column++) {
                output.add(matrix[topRow][column]);
            }

            for (int row = topRow + 1; row <= bottomRow; row++) {
                output.add(matrix[row][rightColumn]);
            }

            if (topRow < bottomRow && leftColumn < rightColumn) {
                for (int column = rightColumn - 1; column > leftColumn; column--) {
                    output.add(matrix[bottomRow][column]);
                }

                for (int row = bottomRow; row > topRow; row--) {
                    output.add(matrix[row][leftColumn]);
                }
            }

            topRow++;
            bottomRow--;
            rightColumn--;
            leftColumn++;
        }

        return output;
    }
}