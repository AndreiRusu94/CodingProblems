package first;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

  Example 1:

    Input: m = 3, n = 2
    Output: 3
    Explanation:
    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Right -> Down
    2. Right -> Down -> Right
    3. Down -> Right -> Right


  Example 2:

    Input: m = 7, n = 3
    Output: 28
 */

public class Problem62 {
    public static void main(String[] args) {
        Solution62 solution = new Solution62();

        int[] input = {1, 2, 3, 4, 5};
        System.out.println(solution.uniquePaths(7, 3));

    }
}

class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            map[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }

        return map[n-1][m-1];
    }
}
