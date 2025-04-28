package second;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
*/

import java.util.Arrays;

public class Problem64 {
    public static void main(String[] args) {
        Solution64 solution = new Solution64();
        int[][] grid = new int[][] {{1, 2, 3}, {4, 5, 6}};

        System.out.println(solution.minPathSum(grid));
    }
}

class Solution64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return buildDp(dp, grid, grid.length - 1, grid[0].length - 1);
    }

    private int buildDp(int[][] dp, int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        int up = buildDp(dp, grid, i - 1, j);
        int left = buildDp(dp, grid, i, j - 1);

        return grid[i][j] + Math.min(up, left);
    }
}
