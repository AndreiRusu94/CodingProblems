package fourth;
/*
There is an m x n grid where you are allowed to move either down or to the right at any point in time.

Given the two integers m and n, return the number of possible unique paths that can be taken from the top-left corner of the grid
(grid[0][0]) to the bottom-right corner (grid[m - 1][n - 1]).

You may assume the output will fit in a 32-bit integer.

Example 1:

Input: m = 3, n = 6

Output: 21

*/

import java.util.Arrays;

public class ProblemNC26 {
    public static void main(String[] args) {
        SolutionNC26 solution = new SolutionNC26();

        System.out.println(solution.uniquePaths(4, 3));
    }

}

class SolutionNC26 {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return memoization(0, 0, m, n, memo);
    }

    private int memoization(int i, int j, int m, int n, int[][] memo) {
        if (i == m || j == n) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        memo[i][j] = memoization(i + 1, j, m, n, memo) + memoization(i, j + 1, m, n, memo);
        return memo[i][j];
    }
}