package fourth;
/*
You are given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner
(row1, col1) and lower right corner (row2, col2).
You must design an algorithm where sumRegion works on O(1) time complexity.
Example 1:

Input: ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]

Output: [null, 8, 11, 12]
Explanation:

NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e. sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e. sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e. sum of the blue rectangle)

*/

public class ProblemNC55 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        SolutionNC55.NumMatrix obj = new SolutionNC55.NumMatrix(matrix);
        System.out.println(obj.sumRegion(3, 2, 4, 4));
    }
}

class SolutionNC55 {

    static class NumMatrix {

        int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            prefixSum = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                int total = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    total += matrix[i][j];
                    prefixSum[i][j] = total;
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                int prefixSumRight = prefixSum[i][col2];
                int prefixSumLeft = col1 > 0 ? prefixSum[i][col1 - 1] : 0;
                sum += (prefixSumRight - prefixSumLeft);
            }

            return sum;
        }
    }

}

