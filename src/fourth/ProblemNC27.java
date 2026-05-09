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

public class ProblemNC27 {
    public static void main(String[] args) {
        SolutionNC27 solution = new SolutionNC27();

        System.out.println(solution.uniquePaths(3, 6));
    }

}

class SolutionNC27 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
}