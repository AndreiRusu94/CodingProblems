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

public class ProblemNC28 {
    public static void main(String[] args) {
        SolutionNC28 solution = new SolutionNC28();

        System.out.println(solution.uniquePaths(3, 6));
    }

}

class SolutionNC28 {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        Arrays.fill(prevRow, 1);

        for (int i = 0; i < m - 1; i++) {
            int[] currRow = new int[n];
            Arrays.fill(currRow, 1);

            for (int j = n - 2; j >= 0; j--) {
                currRow[j] = currRow[j + 1] + prevRow[j];
            }

            prevRow = currRow;
        }

        return prevRow[0];
    }
}