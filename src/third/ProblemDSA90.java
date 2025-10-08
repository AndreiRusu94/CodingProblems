package third;
/*
Given an n*m matrix where all numbers are distinct, the task is to find the maximum length path (starting from any cell) such that all cells along 
the path are in increasing order with a difference of 1. We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or 
(i, j+1) or (i-1, j) or (i, j-1) with the condition that the adjacent cells have a difference of 1.

Example: 

Input:
n = 3, m = 3
matrix[][] = [[1 2 9],
                     [5 3 8],
                    [4 6 7]]

Output: 4
Explanation:  The longest increasing path is  [6, 7, 8, 9]. 

Input: 
n = 3, m = 3
matrix[][] = [[3 4 5],
                     [6 7 8],
                     [10 2 1]]
Output: 3
Explanation: The longest increasing path is [3, 4, 5].

*/

import java.util.Arrays;

public class ProblemDSA90 {
    public static void main(String[] args) {
        SolutionDSA90 solution = new SolutionDSA90();

        int[][] matrix = {
                {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}
        };
        System.out.println(solution.longestIncreasingPath(matrix));
    }
}

class SolutionDSA90 {

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int longest = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = longestPath(matrix, memo, i, j);
                longest = Math.max(longest, val);
            }
        }

        return longest;
    }

    private int longestPath(int[][] matrix, int[][] memo, int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int ans = 1;

        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;

            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] + 1 == matrix[x][y]) {
                ans = Math.max(ans, 1 + longestPath(matrix, memo, x, y));
            }
        }

        memo[i][j] = ans;
        return ans;
    }
}

