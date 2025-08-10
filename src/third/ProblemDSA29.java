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

public class ProblemDSA29 {

    public static void main(String[] args) {
        SolutionDSA29 solution = new SolutionDSA29();
        int[][] mat = {
                {1, 5, 9},
                {14, 20, 21},
                {30, 34, 43}
        };
        int target = 20;

        System.out.println(solution.searchMatrix(mat, target));
    }
}

class SolutionDSA29 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int onRow = 0;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && matrix[i][m - 1] >= target) {
                onRow = i;
                break;
            }
        }

        int left = 0, right = m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[onRow][mid] == target) {
                return true;
            }

            if (matrix[onRow][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}