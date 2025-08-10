package third;

/*
Given two sorted matrices mat1 and mat2 of size n x n of distinct elements. Given a value x, the task is to count all pairs from both matrices whose sum is equal to x.

Note: The pair has an element from each matrix. Matrices are strictly sorted which means that matrices are sorted in a way such that all elements in a row are sorted in increasing order and for row ‘i’, where 1 <= i <= n-1, first element of row 'i' is greater than the last element of row 'i-1'.

Example:

Input : mat1[][] =  [[1, 5, 6],
                     [8, 10, 11],
                     [15, 16, 18]]

    mat2[][] = [[2, 4, 7],
                [9, 10, 12],
                [13, 16, 20]]
       x = 21
Output : 4
The pairs are: (1, 20), (5, 16), (8, 13) and (11, 10).
*/

public class ProblemDSA31 {

    public static void main(String[] args) {
        SolutionDSA31 solution = new SolutionDSA31();
        int[][] mat1 = {
                {1, 5, 6},
                {8, 10, 11},
                {15, 16, 18}
        };

        int[][] mat2 = {
                {2, 4, 7},
                {9, 10, 12},
                {13, 16, 20}
        };

        int target = 21;

        System.out.println(solution.countPairs(mat1, mat2, target));
    }
}

class SolutionDSA31 {
    public int countPairs(int[][] matrix1, int[][] matrix2, int target) {
        int n = matrix1.length;
        int left = 0;
        int right = n * n - 1;
        int count = 0;

        while (left < n * n && right >= 0) {
            int r1 = left / n, c1 = left % n;
            int r2 = right / n, c2 = right % n;

            int pair = matrix1[r1][c1] + matrix2[r2][c2];
            if (pair == target) {
                count++;
                right--;
                left++;
            } else {
                if (pair > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

}