/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

  Example:

    Input:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    Output: 7
    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */


public class Problem64 {
    public static void main(String[] args) {
        Solution64 solution = new Solution64();

        int[][] obstacleGrid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(solution.minPathSum(obstacleGrid));
    }
}

class Solution64 {
    public int minPathSum(int[][] grid) {
        int rowsLength = grid.length, columnsLength = grid[0].length;

        for (int i = 0 ; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                }

                if (j == 0 && i != 0) {
                    grid[i][j] += grid[i - 1][j];
                }

                if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        return grid[rowsLength - 1][columnsLength - 1];
    }
}
