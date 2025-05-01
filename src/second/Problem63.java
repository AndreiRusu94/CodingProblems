package second;
/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
*/

import java.util.Arrays;

public class Problem63 {
    public static void main(String[] args) {
        Solution63 solution = new Solution63();
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(solution.uniquePathsWithObstacles(grid));
    }
}

class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[] prev = new int[m];
        int[] current = new int[m];
        prev[0] = 1;

        for (int i = 0; i < n; i++) {
            current[0] = obstacleGrid[i][0] == 1 ? 0 : prev[0];
            for (int j = 1; j < m; j++) {
                current[j] = obstacleGrid[i][j] == 1 ? 0 : prev[j] + current[j - 1];
            }

            System.arraycopy(current, 0, prev, 0, m);
        }

        return prev[m - 1];
    }
}
