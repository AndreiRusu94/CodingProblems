package third;

/*
Given a sorted matrix mat[][] of size n × m and an integer x, determine whether x is present in the matrix.
The matrix is sorted in the following way:

Each row is sorted in increasing order.
The first element of each row is greater than or equal to the last element of the previous row
(i.e., mat[i][0] ≥ mat[i−1][m−1] for all 1 ≤ i < n).
Examples:

Input: x = 14, mat[][] = [[ 1,  5,  9],
                                        [14, 20, 21],
                                        [30, 34, 43]]
Output: true
Explanation: The value 14 is present in the second row, first column of the matrix.

Input: x = 42, mat[][] = [[ 1,  5,  9,  11],
                                         [14, 20, 21, 26],
                                        [30, 34, 43, 50]]
Output: false
Explanation: The value 42 does not appear in the matrix.
*/

public class ProblemDSA30 {

    public static void main(String[] args) {
        SolutionDSA30 solution = new SolutionDSA30();
        int[][] mat = {
                {1, 5, 9},
                {14, 20, 21},
                {30, 34, 43}
        };
        int target = 20;

        System.out.println(solution.searchMatrix(mat, target));
    }
}

class SolutionDSA30 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int high = n * m - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % m;

            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;

    }

}