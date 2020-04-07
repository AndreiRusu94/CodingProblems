/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

  Example:

    Input: 3
    Output:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
 */

import java.util.Arrays;

public class Problem59 {
    public static void main(String[] args) {
        Solution59 solution = new Solution59();

        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
    }
}

class Solution59 {
    public int[][] generateMatrix(int n) {
        int value = 1;

        int[][] output = new int[n][n];

        int topRow = 0, bottomRow = n-1, leftColumn = 0, rightColumn = n-1;

        while (value <= n * n && topRow <= bottomRow && leftColumn <= rightColumn) {
            for (int i = leftColumn; i <= rightColumn; i++) {
                output[topRow][i] = value++;
            }

            for (int i = topRow + 1; i <= bottomRow; i++) {
                output[i][rightColumn] = value++;
            }

            if (value <= n * n && topRow < bottomRow && leftColumn < rightColumn) {
                for (int i = rightColumn - 1; i >= leftColumn + 1; i--) {
                    output[bottomRow][i] = value++;
                }

                for (int i = bottomRow; i >= topRow + 1; i--) {
                    output[i][leftColumn] = value++;
                }
            }

            topRow++;
            bottomRow--;
            leftColumn++;
            rightColumn--;
        }

        return output;
    }
}
